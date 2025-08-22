package com.tripwise.tripprofile.service;

import com.tripwise.tripprofile.model.UserProfile;
import com.tripwise.tripprofile.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserProfileService {

    private final UserProfileRepository repo;

    public UserProfileService(UserProfileRepository repo) {
        this.repo = repo;
    }

    /**
     * Returns the profile for the given userId.
     * If not found, throws IllegalStateException (will be mapped to 404 in the Controller layer).
     */
    @Transactional(readOnly = true)
    public UserProfile getByUserId(String userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new IllegalStateException("PROFILE_NOT_FOUND"));
    }

    /**
     * Upsert: Updates if it exists, creates and returns if it doesn't.
     */
    @Transactional
    public UserProfile upsert(String userId, String name, String avatarUrl, String locale) {
        UserProfile profile = repo.findByUserId(userId).orElse(null);
        if (profile == null) {
            profile = new UserProfile(userId, name, avatarUrl, locale);
        } else {
            if (name != null && !name.isBlank()) profile.setName(name);
            profile.setAvatarUrl(avatarUrl);
            if (locale != null && !locale.isBlank()) profile.setLocale(locale);
        }
        return repo.save(profile);
    }
}
