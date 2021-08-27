package com.innowise.exeptions;

public class EnumMenuExeption extends Exception {
    public EnumMenuExeption() {
    }

    public EnumMenuExeption(String message) {
        super(message);
    }

    public EnumMenuExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EnumMenuExeption(Throwable cause) {
        super(cause);
    }

    public EnumMenuExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
