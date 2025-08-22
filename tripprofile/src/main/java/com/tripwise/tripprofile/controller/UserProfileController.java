package com.tripwise.tripprofile.controller;

import com.tripwise.tripprofile.dto.UpsertProfileRequest;
import com.tripwise.tripprofile.dto.UserProfileResponse;
import com.tripwise.tripprofile.model.UserProfile;
import com.tripwise.tripprofile.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tripprofile")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> me(@RequestHeader(name = "X-User-Id", required = false) String userId) {
        if (!StringUtils.hasText(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing header: X-User-Id");
        }
        try {
            UserProfile profile = service.getByUserId(userId);
            return ResponseEntity.ok(toResponse(profile));
        } catch (IllegalStateException ex) {
            // PROFILE_NOT_FOUND -> 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/me")
    public ResponseEntity<UserProfileResponse> upsert(
            @RequestHeader(name = "X-User-Id", required = false) String userId,
            @Valid @RequestBody UpsertProfileRequest body) {
        if (!StringUtils.hasText(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing header: X-User-Id");
        }
        UserProfile saved = service.upsert(userId, body.getName(), body.getAvatarUrl(), body.getLocale());
        // let's not worry about distinguishing created vs updated for now; return 200 OK
        return ResponseEntity.ok(toResponse(saved));
    }

    // --- helpers ---
    private static UserProfileResponse toResponse(UserProfile p) {
        UserProfileResponse resp = new UserProfileResponse();
        resp.setId(p.getId());
        resp.setUserId(p.getUserId());
        resp.setName(p.getName());
        resp.setAvatarUrl(p.getAvatarUrl());
        resp.setLocale(p.getLocale());
        resp.setCreatedAt(p.getCreatedAt());
        return resp;
    }
}
