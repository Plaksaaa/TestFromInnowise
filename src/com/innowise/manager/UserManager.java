package com.innowise.manager;

import com.innowise.entity.User;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public void showUsers(){
        for (User user:users) {
            System.out.println(user);
        }
//        users.stream().forEach(user -> System.out.println());
    }

    public User findUser(String firstName, String lastName) {
        User searchedUser = null;
        for (User user : users) {
            if (user.getFirstName().equalsIgnoreCase(firstName) &&
                user.getLastName().equalsIgnoreCase(lastName)) {
                searchedUser = user;
            }
        }
        return searchedUser;
    }

    public void EditUser(String firstName, String lastName){
        User.Builder builder = User.newBuilder();
         findUser(firstName, lastName);
    }

    @Override
    public String toString() {
        return "UserManager{" +
               "users=" + users +
               '}';
    }
}
