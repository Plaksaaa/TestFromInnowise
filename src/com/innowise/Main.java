package com.innowise;

import com.innowise.entity.User;
import com.innowise.menu.Menu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Menu.menu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
