package com.innowise.manager;

import java.util.regex.Pattern;

public class Validator {

    private Validator() {
    }

    public static boolean isValidEmail(String email){
        return !email.matches("^(.+)@(.+).(.+)$");
    }

    public static boolean isValidPhone(String phoneNumber){
        return !phoneNumber.matches("^\\+375(\\s+)?\\(?(17|29|33|44)\\)?(\\s+)?[0-9]{3}-?[0-9]{2}-?[0-9]{2}$");
    }
}
