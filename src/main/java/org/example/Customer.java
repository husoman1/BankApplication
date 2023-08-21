package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Customer {
    String customerID;

    String customerPassword;
    Double sum;

    String name;
    String surname;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCredentials(ArrayList<Customer> cust1){
        System.out.println("Customer ID Please");
        Scanner scn1 = new Scanner(System.in);
        String input1 = scn1.nextLine();
        System.out.println("Customer PW Please");
        String input2 = scn1.nextLine();
        return loginAccount(input1,input2, cust1);
    }

    public int loginAccount(String ID,String customerPW, ArrayList<Customer> cust1){
        for (int i = 0; i < cust1.size(); i++) {
            if (cust1.get(i).customerID.equals(ID) && cust1.get(i).customerPassword.equals(customerPW)){
                this.customerID = cust1.get(i).customerID;
                this.customerPassword = cust1.get(i).customerPassword;
                this.sum = cust1.get(i).sum;
                this.name = cust1.get(i).name;
                this.surname = cust1.get(i).surname;

                return i;
            }
        }
        return -1;
    }

    public int createAccount(String id,String pw,Double amount,ArrayList<Customer> cus){
        for (int i = 0; i < cus.size(); i++) {
            if (cus.get(i).customerID.equals(id)){
                return -1;
            }
        }

        this.customerID = id;
        this.customerPassword = pw;
        this.sum = amount;
        this.name = null;
        this.surname = null;

        cus.add(this);
        System.out.println(cus.get(1).customerID);
        System.out.println(cus.get(1).customerPassword);


        return 0;
    }
}
