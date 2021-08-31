package com.innowise.menu;

import com.innowise.exceptions.MenuCommandsException;

public enum MenuCommandsEnum {
    CREATE_USER(1),
    PRINT_USERS(2),
    DELETE_USER(3),
    FIND_USER(4),
    EDIT_USER(5),
    EXIT(6);

    private final int code;

    MenuCommandsEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MenuCommandsEnum findActionByCode(int code) throws MenuCommandsException {
        for (MenuCommandsEnum action : values()) {
            if (code == action.getCode()) {
                return action;
            }
        }
        throw new MenuCommandsException(String.format("Not found action with code: %s.", code));
    }
}
