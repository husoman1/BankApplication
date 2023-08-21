package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Menu menu = new Menu();
        menu.initialMessage();
        Scanner scn1 = new Scanner(System.in);
        int input1 = scn1.nextInt();

        // Burayı Interface yapalım sonrasında
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
                System.out.println("Coming soon");
                break;
            default :
                System.out.println("Wrong!");
                break;
        }


    }
}