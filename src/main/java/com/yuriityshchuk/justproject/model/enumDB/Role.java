package com.yuriityshchuk.justproject.model.enumDB;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    MANAGER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name(); //ToString() - тоже подходит
    }
}
