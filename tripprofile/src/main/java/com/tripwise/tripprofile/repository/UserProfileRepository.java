package com.tripwise.tripprofile.repository;

import com.tripwise.tripprofile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserId(String userId);
}
