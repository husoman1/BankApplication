package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        int input1;
        Menu menu = new Menu();

        ObjectMapper mapper = new ObjectMapper();
        try {
            //Customer[] acc1 = mapper.readValue(new File("/Users/huseyineraslan/IdeaProjects/BankApplication/src/main/java/org/example/inputJSON"), Customer[].class);
            ArrayList<Customer> acc1 = mapper.readValue(new File("src/main/java/org/example/inputJSON"), mapper.getTypeFactory().constructCollectionType(List.class, Customer.class));
            //System.out.println("myObjects-->"+myObjects.get(0).customerID);

            // Burayı Interface yapalım sonrasında
        input1 = initApp();
        switch(input1) {
            case 1 :
                Customer cus = new Customer();

                int resultIndex = cus.getCredentials(acc1);
                if (resultIndex>=0) {
                    menu.accountSummary(acc1.get(resultIndex));
                }
                else {
                    System.out.println("Fail!");
                }
                break;
            case 2 :
                menu.createAccount(acc1);
                main(args);
                break;
            case 3 :
                JSON jsonob = new JSON();
                jsonob.prepareOutJSON(acc1);
                //menu.createAccount(acc1);
                //main(args);
                break;
            default :
                System.out.println("Wrong!");
                break;
        }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int initApp(){
        Menu menu = new Menu();
        menu.initialMessage();
        Scanner scn1 = new Scanner(System.in);
        return scn1.nextInt();
    }

}