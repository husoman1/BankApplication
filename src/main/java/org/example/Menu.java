package org.example;

import java.util.Scanner;

public class Menu {
    public void initialMessage(){
        System.out.println("Welcome the First Bank Application!");
        System.out.println("Please select options");
        System.out.println("1.Login your account");
        System.out.println("2.Create New Account");
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

    public void createAccount(Customer[] cuss1){
        Scanner scn1 = new Scanner(System.in);
        System.out.println("Please enter an ID");
        String id = scn1.nextLine();
        System.out.println("Please enter a PW");
        String pw = scn1.nextLine();
        System.out.println("Please select amount to deposit");
        Double amount = scn1.nextDouble();
        Customer cus = new Customer();
        int result = cus.createAccount(id,pw,amount,cuss1);
        if (result<0){
            System.out.println("Already exist username");
        }
        else {
            System.out.println("User succesfully created");
        }
    }

}
