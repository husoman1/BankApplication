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

    public static void appFlow(int selection, Database db){
        Menu menu = new Menu();
        switch (selection) {
            case 1 -> {
                Customer customer = new Customer();
                int resultIndex = customer.getCredentials(db);
                if (resultIndex >= 0) {
                    menu.accountSummary(db.instance.get(resultIndex), db);
                } else {
                    System.out.println("Username or Password is wrong!");
                    appFlow(initApp(), db);
                }
            }
            case 2 -> {
                Customer customer = menu.createAccount(db);
                db.instance.add(customer);
                appFlow(initApp(), db);
            }
            case 3 -> {
                Json jsonobj = new Json();
                jsonobj.prepareOutJSON(db);
            }
            default -> {
                System.out.println("Please select a valid menu item");
                appFlow(initApp(), db);
            }
        }
    }

    public void initialMessage(){
        System.out.println("------------------------------------");
        System.out.println("|       Welcome the First Bank      |");
        System.out.println("------------------------------------");
        System.out.println("|       Please select an option     |");
        System.out.println("|   1.Login                         |");
        System.out.println("|   2.Create New Account            |");
        System.out.println("|   3.Prepare Out JSON              |");
        System.out.println("------------------------------------");
        System.out.print(  "    Selection:");
    }
    public void accountSummary(Customer acc, Database db){
        System.out.println("=====================================");
        System.out.println("    Your Balance: " + acc.getSum());
        System.out.println("=====================================");
        System.out.println("                  *                  ");
        System.out.println("------------------------------------");
        System.out.println("|       Please select an option     |");
        System.out.println("------------------------------------");
        System.out.println("|   1.Deposit Money                 |");
        System.out.println("|   2.Withdraw Money                |");
        System.out.println("|   3.Transfer Money                |");
        System.out.println("|   4.Log Out                       |");
        System.out.println("------------------------------------");
        System.out.print(  "    Selection:");
        Actions act = new Actions();
        Scanner scn1 = new Scanner(System.in);
        int input1 = scn1.nextInt();
        switch (input1) {
            case 1 -> {
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println("Please enter Amount");
                System.out.println("------------------------------------");
                System.out.print("Amount:");
                double amount = scn1.nextDouble();
                act.depositMoney(acc, amount);

                accountSummary(acc,db);
            }
            case 2 -> {
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println("Please enter Amount");
                System.out.println("------------------------------------");
                System.out.print("Amount:");
                double amount2 = scn1.nextDouble();
                act.withdrawMoney(acc, amount2);

                accountSummary(acc,db);
            }
            case 3 -> {
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println("Please Username of account that you want to transfer money");
                System.out.print("Username:");
                String transferUsername = scn1.next();
                System.out.println("------------------------------------");
                System.out.println("Please enter transfer amount");
                System.out.print("Amount:");
                double amount3 = scn1.nextDouble();

                Customer tempTransferAccount = new Customer();
                int resultIndex = tempTransferAccount.getAccountIndexByUsername(transferUsername,db);

                Customer transferAccount = db.instance.get(resultIndex);
                act.transferMoney(acc,transferAccount,amount3);

                accountSummary(acc,db);
            }
            case 4 ->{
                System.out.println("------------------------------------");
                System.out.println("       -----  --------  -----      ");
                System.out.println("       -----  GOOD BYE  -----      ");
                System.out.println("       -----  --------  -----      ");
                System.out.println("------------------------------------");
            }
            default -> {
                System.out.println("Please select a valid menu item");
                accountSummary(acc,db);
            }
        }

    }

    public Customer createAccount(Database cuss1){

        String uniqueID = UUID.randomUUID().toString();

        Scanner scn1 = new Scanner(System.in);

        System.out.println("Please enter a Username");
        String id = scn1.nextLine();
        System.out.println("Please enter a Password");
        String pw = scn1.nextLine();
        System.out.println("Please enter amount to deposit");
        Double amount = scn1.nextDouble();

        Customer cus = new Customer();
        Customer result = cus.createAccount(uniqueID,id,pw,amount,cuss1);

        if (result.customerID == null){

            System.out.println("This Username already exists");
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
