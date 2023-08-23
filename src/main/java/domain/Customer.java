package domain;

import java.util.Scanner;

public class Customer {
    String customerID;
    String customerUID;
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

    public int getCredentials(Database cust1){
        System.out.println("Customer ID Please");
        Scanner scn1 = new Scanner(System.in);
        String input1 = scn1.nextLine();
        System.out.println("Customer PW Please");
        String input2 = scn1.nextLine();
        return loginAccount(input1, input2, cust1);
    }

    public int loginAccount(String ID, String customerPW, Database cust1){
        for (int i = 0; i < cust1.instance.size(); i++) {
            if (cust1.instance.get(i).customerID.equals(ID) && cust1.instance.get(i).customerPassword.equals(customerPW)){
                this.customerID = cust1.instance.get(i).customerID;
                this.customerPassword = cust1.instance.get(i).customerPassword;
                this.sum = cust1.instance.get(i).sum;
                this.name = cust1.instance.get(i).name;
                this.surname = cust1.instance.get(i).surname;

                return i;
            }
        }
        return -1;
    }

    public Customer createAccount(String uid, String id, String pw, Double amount, Database cus){
        for (int i = 0; i < cus.instance.size(); i++) {
            if (cus.instance.get(i).customerID.equals(id)){
                return null;
            }
        }

        this.customerID = id;
        this.customerPassword = pw;
        this.sum = amount;
        this.customerUID =
        this.name = null;
        this.surname = null;

        //cus.add(this);
        //System.out.println(cus.get(1).customerID);
        //System.out.println(cus.get(1).customerPassword);


        return this;
    }

    public void addAccountToArrayList(){
        System.out.println(this.customerID);
    }
}
