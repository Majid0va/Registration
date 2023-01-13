package com.atl.register.config;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.atl.register.config.UserPermissions.*;

public enum UserRoles {
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, USER_EDIT)),
    GUEST(Sets.newHashSet());

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return this.permissions;
    }
}
