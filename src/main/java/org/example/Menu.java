package org.example;

public class Menu {
    public void initialMessage(){
        System.out.println("Welcome the First Bank Application!");
        System.out.println("Please select options");
        System.out.println("1.Login your account");
        System.out.println("2.Create New Account");
    }
    public void accountSummary(Account acc){
        System.out.println("Login Successful");
        System.out.println("Your sum is " + acc.getSum(acc.customerID));
    }
}
