package com.cem.learning.oop;

public class Organizer extends PlatformUser {
    private final String organizationName;

    public Organizer(String userId, String displayName, String organizationName) {
        super(userId, displayName);
        this.organizationName = organizationName;
    }

    public String getOrganizationName() { return organizationName; }

    @Override
    public String roleName() { return "ORGANIZER"; }

    @Override
    public String dashboardLabel() { return "Manage your events"; }
}
