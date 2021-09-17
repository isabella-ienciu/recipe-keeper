package com.isbl.recipekeeper.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.isbl.recipekeeper.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(RECIPE_READ, RECIPE_WRITE, INGREDIENTS_READ, INGREDIENTS_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
