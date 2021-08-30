package com.innowise.builder;

import com.innowise.entity.NewRole;
import com.innowise.entity.Role;
import com.innowise.entity.User;
import com.innowise.exeptions.RoleExeption;
import com.innowise.manager.Validator;

import java.util.*;

public class UserConsoleReader {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isValid;

    public UserConsoleReader() {
    }

    public User createUser() {
        User.Builder builder = User.newBuilder();

        builder.setFirstName(readFirstName());

        builder.setLastName(readLastName());

        builder.setEmail(readEmail());


//        builder.setRoleMap(readRoleMap());

        builder.setPhoneList(readPhone());

        return builder.build();
    }

    private String readFirstName() {
        System.out.println("Enter a First Name");
        return scanner.nextLine();
    }

    private String readLastName() {
        System.out.println("Enter a Last Name");
        return scanner.nextLine();
    }

    private String readEmail() {
        do {
            isValid = true;
            System.out.print("Enter a Valid Email: ");
            String email = scanner.nextLine();

            try {
                if (Validator.isValidEmail(email)) {
                    isValid = false;
                    System.out.println("Invalid Email. Try Again.");
                } else {
                    return email;
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Invalid Email. Try Again.");
            }
        } while (!isValid);
        return null;
    }

    /*private Map<Integer, Role> readRoleMap() {
        Map<Integer, Role> roleMap = new HashMap<>();
        do {
            isValid = true;
            System.out.println("Enter a Level: ");

            int level = scanner.nextShort();

            if (level < 1 || level > 3) {
                isValid = false;
                System.out.println("Enter a Correct level!");
            }

            System.out.println("Enter a Role: ");

            Role role = null;
            try {
                role = Role.findRoleByCode(scanner.nextInt());
                if (level == 3) {
                    roleMap.put(3, Role.SUPER_ADMIN);
//                    return roleMap;
                } else if ((level == 1 && role.name().equalsIgnoreCase("Customer")) ||
                           (level == 1 && role.name().equalsIgnoreCase("User")) ||
                           (level == 2 && role.name().equalsIgnoreCase("Provider")) ||
                           (level == 2 && role.name().equalsIgnoreCase("Admin"))) {
                    isValid = false;
                    System.out.println("Invalid Role. Try Again.");
                } else {
                    roleMap.put(level, role);
                }
            } catch (RoleExeption roleExeption) {
                roleExeption.printStackTrace();
            }
        } while (!isValid);
        return roleMap;
    }*/

    private List<String> readPhone() {
        List<String> phones = new ArrayList<>();
        do {
            isValid = true;
            System.out.print("Enter a Phone Number: ");
            String phone = scanner.nextLine();

            try {
                if (Validator.isValidPhone(phone)) {
                    isValid = false;
                    System.out.println("Invalid Phone. Try Again.");
                } else {
                    phones.add(phone);

                    System.out.println(" do");

                    if (scanner.nextLine().equalsIgnoreCase("yes")){
                        readPhone();
                    }
                }
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Invalid Phone. Try Again.");
            }
        } while (!isValid);
        return phones;
    }

    private Map<Integer, NewRole> readRoleMapp() {
        Map<Integer, NewRole> roleMap = new HashMap<>();
        do {
            isValid = true;
            System.out.println("Enter a Level: ");

            int level = scanner.nextShort();

            if (level < 1 || level > 3) {
                isValid = false;
                System.out.println("Enter a Correct level!");
            }

            System.out.println("Enter a Role: ");

            NewRole role = new NewRole(scanner.nextLine());

                if (level == 3) {
                    role.setRole("Super_Admin");
                    roleMap.put(3, role);
                    return roleMap;
                } else if ((level == 1 && role.getRole().equalsIgnoreCase("Customer")) ||
                           (level == 1 && role.getRole().equalsIgnoreCase("User")) ||
                           (level == 2 && role.getRole().equalsIgnoreCase("Provider")) ||
                           (level == 2 && role.getRole().equalsIgnoreCase("Admin"))) {
                    isValid = false;
                    System.out.println("Invalid Role. Try Again.");
                } else {
                    roleMap.put(level, role);
                }
        } while (!isValid);
        return roleMap;
    }
}
