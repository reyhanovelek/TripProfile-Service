package com.tripwise.tripprofile.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_profile",
        uniqueConstraints = @UniqueConstraint(name = "uk_user_profile_user_id", columnNames = "user_id"))
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, length = 100)
    private String userId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

    @Column(name = "locale", length = 10)
    private String locale = "en-US";

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    public UserProfile() { }

    public UserProfile(String userId, String name, String avatarUrl, String locale) {
        this.userId = userId;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.locale = (locale == null || locale.isBlank()) ? "en-US" : locale;
    }

    @PrePersist
    public void onCreate() {
        if (createdAt == null) {
            createdAt = Instant.now();
        }
        if (locale == null || locale.isBlank()) {
            locale = "en-US";
        }
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
