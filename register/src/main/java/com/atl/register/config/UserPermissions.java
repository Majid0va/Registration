package com.atl.register.config;

public enum UserPermissions {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_EDIT("user:edit");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}