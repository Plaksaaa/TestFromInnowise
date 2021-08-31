package com.innowise.menu;

import com.innowise.console_reader.UserConsoleReader;
import com.innowise.file.util.FileWriterUtil;
import com.innowise.manager.UserManager;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        UserConsoleReader reader = new UserConsoleReader();
        UserManager manager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            MenuCommandsEnum command = MenuCommandsEnum.values()[Integer.parseInt(scanner.nextLine().trim()) - 1];
            switch (command) {
                case CREATE_USER:
                    manager.addUser(reader.createUser());
                    FileWriterUtil.writeToFileEnd("Data/txt", manager.toString());
                    continue;
                case PRINT_USERS:
                    manager.showUsers();
                    break;
                case DELETE_USER:
                    System.out.println("Enter a User First Name and User Last Name to Delete: ");
                    manager.deleteUser(scanner.nextLine(), scanner.nextLine());
                    break;
                case FIND_USER:
                    System.out.println("Enter a User First Name and a User Last Name to Find: ");
                    System.out.println(manager.findUser(scanner.nextLine(), scanner.nextLine()));
                    break;
                case EDIT_USER:
                    System.out.println("Enter a User First Name and User Last Name to Edit: ");
                    manager.deleteUser(scanner.nextLine(),scanner.nextLine());
                    manager.addUser(reader.createUser());
                    FileWriterUtil.writeToFileEnd("Data/txt", manager.toString());
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("No such command!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("""
                Hello From Menu 
                1) - Create User
                2) - Show All Users
                3) - Remove User
                4) - Find User
                5) - Edit User
                6) - Exit       
                """);
    }
}
