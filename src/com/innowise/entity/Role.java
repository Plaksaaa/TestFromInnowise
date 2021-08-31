package com.innowise.entity;

import com.innowise.exceptions.RoleException;

public enum Role {
    USER(1),
    CUSTOMER(2),
    ADMIN(3),
    PROVIDER(4),
    SUPER_ADMIN(5);

    private final int code;

    Role(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Role findRoleByCode(int code) throws RoleException {
        for (Role role : values()) {
            if (role.getCode() == code) {
                return role;
            }
        }
        throw new RoleException(String.format("Not found role with code: %s.", code));
    }
}
