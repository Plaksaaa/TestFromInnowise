package com.innowise.entity;

import com.innowise.exeptions.RoleExeption;
import com.innowise.menu.EnumMenu;

public enum Role {
    USER('u'),
    CUSTOMER('c'),
    ADMIN('a'),
    PROVIDER('p'),
    SUPER_ADMIN('s');

    private final char code;

    Role(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Role findRoleByCode(char code) throws RoleExeption {
        for (Role role : values()) {
            if (code == role.getCode()) {
                return role;
            }
        }
        throw new RoleExeption(String.format("Not found role with code: %s.", code));
    }

}
