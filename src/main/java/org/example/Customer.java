package org.example;

import java.lang.reflect.Array;
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

    public int getCredentials(Customer[] cust1){
        System.out.println("Customer ID Please");
        Scanner scn1 = new Scanner(System.in);
        String input1 = scn1.nextLine();
        System.out.println("Customer PW Please");
        String input2 = scn1.nextLine();
        return loginAccount(input1,input2, cust1);
    }

    public int loginAccount(String ID,String customerPW, Customer[] cust1){
        for (int i = 0; i < cust1.length; i++) {
            if (cust1[i].customerID.equals(ID) && cust1[i].customerPassword.equals(customerPW)){
                this.customerID = cust1[i].customerID;
                this.customerPassword = cust1[i].customerPassword;
                this.sum = cust1[i].sum;
                this.name = cust1[i].name;
                this.surname = cust1[i].surname;

                return i;
            }
        }
        return -1;
    }

    public int createAccount(String id,String pw,Double amount,Customer[] cus){
        for (int i = 0; i < cus.length; i++) {
            if (cus[i].customerID.equals(id)){
                return -1;
            }
        }

        this.customerID = id;
        this.customerPassword = pw;
        this.sum = amount;
        this.name = null;
        this.surname = null;

        Customer[] custTemp = Arrays.copyOf(cus, cus.length+1);

        custTemp[cus.length-1].customerID = id;
        custTemp[cus.length-1].customerPassword = pw;
        custTemp[cus.length-1].sum = amount;

        return custTemp.length-1;
    }
}
