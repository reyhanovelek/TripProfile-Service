package com.tripwise.tripprofile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpsertProfileRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 255)
    private String avatarUrl;

    @Size(max = 10)
    private String locale;

    public UpsertProfileRequest() {}

    public UpsertProfileRequest(String name, String avatarUrl, String locale) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.locale = locale;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }
}
