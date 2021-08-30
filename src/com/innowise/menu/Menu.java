package com.innowise.menu;

import com.innowise.builder.UserConsoleReader;
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
            EnumMenu command = EnumMenu.values()[Integer.parseInt(scanner.nextLine().trim()) - 1];
            switch (command) {
                case CREATE_USER:
                    manager.addUser(reader.createUser());
                    FileWriterUtil.writeToFileEnd("Data/txt", manager.toString());
                    break;
                case PRINT_USERS:
                    manager.showUsers();
                    break;
                case DELETE_USER_BY_INDEX:
                    System.out.println("Enter a user index to delete");
//                    users.remove(scanner.nextInt());
                    break;
                case FIND_USER:
                    System.out.println("Enter a user first name and a user last name");
//                    findUser(scanner.nextLine(), scanner.nextLine());
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
