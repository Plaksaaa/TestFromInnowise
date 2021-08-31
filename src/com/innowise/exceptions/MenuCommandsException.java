package com.innowise.exceptions;

public class MenuCommandsException extends Exception {
    public MenuCommandsException() {
    }

    public MenuCommandsException(String message) {
        super(message);
    }

    public MenuCommandsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuCommandsException(Throwable cause) {
        super(cause);
    }

    public MenuCommandsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
