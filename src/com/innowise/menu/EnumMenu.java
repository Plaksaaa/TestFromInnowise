package com.innowise.menu;

import com.innowise.exeptions.EnumMenuExeption;

public enum EnumMenu {
    CREATE_USER(0),
    PRINT_USERS(1),
    DELETE_USER_BY_INDEX(2),
    FIND_USER(3),
    EXIT(4);

    private final int code;

    EnumMenu(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EnumMenu findActionByCode(int code) throws EnumMenuExeption {
        for (EnumMenu action : values()) {
            if (code == action.getCode()) {
                return action;
            }
        }
        throw new EnumMenuExeption();
    }
}
