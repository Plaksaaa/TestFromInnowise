package com.innowise.builder;

import com.innowise.entity.Role;
import com.innowise.entity.User;
import com.innowise.exeptions.RoleExeption;
import com.innowise.manager.StringManager;

import java.io.IOException;
import java.util.Scanner;

public final class UserBuilder {

    private UserBuilder() {
    }

    public static User createUser() throws IOException {
        boolean isValid;
        var scanner = new Scanner(System.in);

        User.Builder builder = User.newBuilder();

        System.out.println("Enter a Firstname: ");

        String fName = scanner.nextLine();

        builder.setFirstName(fName);

        System.out.println("Enter a Lastname: ");

        String lName = scanner.nextLine();

        builder.setLastName(lName);

        do {
            isValid = true;
            System.out.print("Enter a Valid Email: ");
            String email = scanner.nextLine();

            try {
                if (StringManager.isValidEmailString(email)) {
                    isValid = false;
                    System.out.println("Invalid Email. Try Again.");
                } else {
                    builder.setEmail(email);
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Invalid Email. Try Again.");
            }
        } while (!isValid);

        do {
            isValid = true;
            System.out.println("Enter a First Role: ");

            String fTemp = scanner.nextLine();
            char Fc = fTemp.charAt(0);

            Role firstRole = null;
            try {
                firstRole = Role.findRoleByCode(Fc);
            } catch (RoleExeption roleExeption) {
                roleExeption.printStackTrace();
            }

            System.out.println("Enter a Second Role: ");

            String sTemp = scanner.nextLine();
            char sH = sTemp.charAt(0);

            Role secondRole = null;
            try {
                secondRole = Role.findRoleByCode(sH);
            } catch (RoleExeption roleExeption) {
                roleExeption.printStackTrace();
            }

            if (firstRole.getCode() == 's') {
                builder.setFirstRole(firstRole);
                builder.setSecondRole(null);
            } else if ((firstRole.getCode() == 'u' && secondRole.getCode() == 'c') ||
                       (firstRole.getCode() == 'a' && secondRole.getCode() == 'p') ||
                       (firstRole.getCode() == 'c' && secondRole.getCode() == 'u') ||
                       (firstRole.getCode() == 'p' && secondRole.getCode() == 'a') ||
                       (firstRole.getCode() == secondRole.getCode())) {
                isValid = false;
                System.out.println("Invalid Role. Try Again.");
            } else {
                builder.setFirstRole(firstRole);
                builder.setSecondRole(secondRole);
            }
        } while (!isValid);

        do {
            isValid = true;
            System.out.print("Enter a First Phone Number or Empty: ");
            String firstPhone = scanner.nextLine();

            try {
                if (StringManager.isValidPhoneString(firstPhone)) {
                    isValid = false;
                    System.out.println("Invalid Phone. Try Again.");
                } else if (firstPhone.equals("")) {
                    builder.setSecondPhoneNumber(null);
                } else {
                    builder.setFirstPhoneNumber(firstPhone);
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Invalid Phone. Try Again.");
            }
        } while (!isValid);

        do {
            isValid = true;
            System.out.print("Enter a Second Phone Number or Empty: ");
            String secondPhone = scanner.nextLine();

            try {
                if (StringManager.isValidPhoneString(secondPhone)) {
                    isValid = false;
                    System.out.println("Invalid Phone. Try Again.");
                } else if (secondPhone.equals("")) {
                    builder.setSecondPhoneNumber(null);
                } else {
                    builder.setSecondPhoneNumber(secondPhone);
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Invalid Phone. Try Again.");
            }
        } while (!isValid);

        do {
            isValid = true;
            System.out.print("Enter a Third Phone Number or Empty: ");
            String thirdPhone = scanner.nextLine();

            try {
                if (StringManager.isValidPhoneString(thirdPhone)) {
                    isValid = false;
                    System.out.println("Invalid Phone. Try Again.");
                } else if (thirdPhone.equals("")){
                    builder.setThirdPhoneNumber(null);
                } else {
                    builder.setThirdPhoneNumber(thirdPhone);
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Invalid Phone. Try Again.");
            }
        } while (!isValid);
        return builder.build();
    }
}
