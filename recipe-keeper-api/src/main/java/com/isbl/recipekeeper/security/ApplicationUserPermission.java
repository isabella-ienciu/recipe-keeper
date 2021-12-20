package com.isbl.recipekeeper.security;

public enum ApplicationUserPermission {
    RECIPE_READ("recipe:read"),
    RECIPE_WRITE("recipe:write"),
    INGREDIENTS_READ("ingredients:read"),
    INGREDIENTS_WRITE("ingredients:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
