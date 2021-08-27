package com.innowise.menu;

import com.innowise.entity.User;
import com.innowise.builder.UserBuilder;
import com.innowise.file.util.FileWriterUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.innowise.manager.UserManager.findUser;
import static com.innowise.manager.UserManager.users;

public class Menu {

    public static void menu() throws IOException {
        var scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            EnumMenu command = EnumMenu.values()[Integer.parseInt(scanner.nextLine().trim()) - 1];
            switch (command) {
                case CREATE_USER:
                    users.add(UserBuilder.createUser());
                    FileWriterUtil.writeToFileEnd("Data/txt", users.toString());
                    break;
                case PRINT_USERS:
                    users.stream().forEach(System.out::println);
                    break;
                case DELETE_USER_BY_INDEX:
                    System.out.println("Введите индекс пользователя которого хотите удалить");
                    users.remove(scanner.nextInt());
                    break;
                case FIND_USER:
                    System.out.println("Введите имя и фамилию пользователя");
                    findUser(scanner.nextLine(), scanner.nextLine());
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("No such command!");
            }
        }
    }
    public static void printMenu(){
        System.out.println("""
                    Hello From Menu 
                    1) - Create User
                    2) - Show All Users
                    3) - Remove User By index
                    4) - Find User By Firstname and LastName
                    5) - Exit       
                    """);
    }
}
