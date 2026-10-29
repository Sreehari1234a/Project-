package com.cem.learning.oop;

public class Admin extends PlatformUser {
    public Admin(String userId, String displayName) {
        super(userId, displayName);
    }

    @Override
    public String roleName() { return "ADMIN"; }

    @Override
    public String dashboardLabel() { return "Platform overview"; }
}
