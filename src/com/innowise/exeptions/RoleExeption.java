package com.innowise.exeptions;

public class RoleExeption extends Exception {
    public RoleExeption() {
    }

    public RoleExeption(String message) {
        super(message);
    }

    public RoleExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleExeption(Throwable cause) {
        super(cause);
    }

    public RoleExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
