package com.innowise.manager;

import com.innowise.entity.Role;
import com.innowise.entity.User;

import java.util.ArrayList;

public class UserManager {
    public static ArrayList<User> users = new ArrayList<>();

//    public static void addUser(User user){
//        users.add(user);
//    }

    public static User findUser(String firstName, String lastName) {
        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(firstName) &&
                user.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(user);
            }
        }
        return user;
    }
//        users.stream()
//                .filter(user -> user.getFirstName().equalsIgnoreCase(firstName) &&
//                                user.getLastName().equalsIgnoreCase(lastName))
//                .forEach(user -> System.out.println());


    public static User EditUser(ArrayList<User> userList, String firstName, String lastName){
        findUser(firstName,lastName){

        }
    }
}
