package com.cem.learning.oop;

public abstract class PlatformUser implements DashboardIdentity {
    private final String userId;
    private String displayName;

    protected PlatformUser(String userId, String displayName) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID is required.");
        }
        this.userId = userId;
        setDisplayName(displayName);
    }

    public String getUserId() { return userId; }
    public String getDisplayName() { return displayName; }

    public void setDisplayName(String displayName) {
        if (displayName == null || displayName.isBlank()) {
            throw new IllegalArgumentException("Display name is required.");
        }
        this.displayName = displayName.trim();
    }

    public abstract String roleName();
}
