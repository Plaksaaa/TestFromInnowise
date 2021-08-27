package com.innowise.manager;

import java.util.regex.Pattern;

public class StringManager {

    private StringManager() {
    }

    public static boolean isValidEmailString(String email){
        return !email.matches("^(.+)@(.+).(.+)$");
    }

    public static boolean isValidPhoneString(String phoneNumber){
        return !phoneNumber.matches("^\\+375(\\s+)?\\(?(17|29|33|44)\\)?(\\s+)?[0-9]{3}-?[0-9]{2}-?[0-9]{2}$"
        +"|");
    }
}
