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

        List<Customer> acc1 =processJSON(); // Process InputJSON as DB
            // make this list


        int input1 = initApp(); //APP Menu init
        appFlow(input1,acc1); // APP init
    }
    public static List<Customer> processJSON(){
        ObjectMapper mapper = new ObjectMapper();
        try {
        return mapper.readValue(new File("src/main/java/org/example/inputJSON"), mapper.getTypeFactory().constructCollectionType(List.class, Customer.class));
        }
        catch (IOException e) {
        e.printStackTrace();
        return null;
    }
    }
    public static int initApp(){
        Menu menu = new Menu();
        menu.initialMessage();
        Scanner scn1 = new Scanner(System.in);
        return scn1.nextInt();

    }

    public static void appFlow(int input1,List<Customer> acc1){
        Menu menu = new Menu();
        //Daha açıklayıcı isimlendirme
        //interface
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
                Customer cus1 =  menu.createAccount(acc1);
                acc1.add(cus1);
                appFlow(initApp(),acc1);
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

}