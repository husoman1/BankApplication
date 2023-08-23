package domain;

import io.Json;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    public static int initApp(){
        Menu menu = new Menu();
        menu.initialMessage();
        Scanner scn1 = new Scanner(System.in);
        return scn1.nextInt();
    }

    public static void appFlow(int input1, Database acc){
        Menu menu = new Menu();
        switch (input1) {
            case 1 -> {
                Customer cus = new Customer();
                int resultIndex = cus.getCredentials(acc);
                if (resultIndex >= 0) {
                    menu.accountSummary(acc.instance.get(resultIndex));
                } else {
                    System.out.println("Fail!");
                }
            }
            case 2 -> {
                Customer cus1 = menu.createAccount(acc);
                acc.instance.add(cus1);
                appFlow(initApp(), acc);
            }
            case 3 -> {
                Json jsonob = new Json();
                jsonob.prepareOutJSON(acc);
            }
            default -> System.out.println("Wrong!");
        }
    }

    public void initialMessage(){
        System.out.println("Welcome the First Bank Application!");
        System.out.println("Please select options");
        System.out.println("1.Login your account");
        System.out.println("2.Create New Account");
        System.out.println("3.Prepare Out JSON");
    }
    public void accountSummary(Customer acc){
        System.out.println("Login Successful");
        System.out.println("Your sum is " + acc.getSum());
        System.out.println("Please select next action");
        System.out.println("1.Deposit Money");
        System.out.println("2.Withdraw Money");
        Actions act = new Actions();
        Scanner scn1 = new Scanner(System.in);
        int input1 = scn1.nextInt();
        switch(input1) {
            case 1 :
                System.out.println("Please enter Amount");
                double amount = scn1.nextDouble();
                act.depositMoney(acc,amount);
                break;
            case 2 :
                System.out.println("Please enter Amount");
                double amount2 = scn1.nextDouble();
                act.withdrawMoney(acc,amount2);
                break;
            default :
                System.out.println("Wrong!");
                break;
        }
    }

    public Customer createAccount(Database cuss1){

        String uniqueID = UUID.randomUUID().toString();

        Scanner scn1 = new Scanner(System.in);

        System.out.println("Please enter a Username");
        String id = scn1.nextLine();
        System.out.println("Please enter a Password");
        String pw = scn1.nextLine();
        System.out.println("Please select amount to deposit");
        Double amount = scn1.nextDouble();

        Customer cus = new Customer();
        Customer result = cus.createAccount(uniqueID,id,pw,amount,cuss1);

        if (result.customerID == null){

            System.out.println("Already exist username");
            return null;

        } else {

            System.out.println("----------------------------");
            System.out.println("| User Successfully Created |");
            System.out.println("----------------------------");
            System.out.println("Account ID      : "+uniqueID);
            System.out.println("Username        : "+id);
            System.out.println("Password        : "+pw);
            System.out.println("Account Balance : "+amount);
            System.out.println("----------------------------");

            return cus;

        }
    }

}
