package com.tripwise.tripprofile.dto;

import java.time.Instant;

public class UserProfileResponse {
    private Long id;
    private String userId;
    private String name;
    private String avatarUrl;
    private String locale;
    private Instant createdAt;

    public UserProfileResponse() {}

    public UserProfileResponse(Long id, String userId, String name, String avatarUrl, String locale, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.locale = locale;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getAvatarUrl() { return avatarUrl; }
    public String getLocale() { return locale; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setName(String name) { this.name = name; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
    public void setLocale(String locale) { this.locale = locale; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
