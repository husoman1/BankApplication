package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        LoggerCustom log = new LoggerCustom();
        int input1;
        Menu menu = new Menu();



        // Burayı Interface yapalım sonrasında
        input1 = initApp();
        switch(input1) {
            case 1 :
                Account acc1 = new Account();
                boolean result = acc1.getCredentials();
                if (result) {
                    menu.accountSummary(acc1);
                }
                else {
                    System.out.println("Fail!");
                }
                break;
            case 2 :
                menu.createAccount();
                main(args);
                break;
            default :
                System.out.println("Wrong!");
                break;
        }
    }
    public static int initApp(){
        Menu menu = new Menu();
        menu.initialMessage();
        Scanner scn1 = new Scanner(System.in);
        return scn1.nextInt();
    }

}