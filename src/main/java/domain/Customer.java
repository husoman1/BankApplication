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

    public int getCredentials(Database db){
        System.out.println("------------------------------------");
        System.out.print("Username: ");
        Scanner scn1 = new Scanner(System.in);
        String custID = scn1.nextLine();
        System.out.print("Password: ");
        String custPW = scn1.nextLine();
        return loginAccount(custID, custPW, db);
    }

    public int loginAccount(String ID, String customerPW, Database db){
        for (int i = 0; i < db.instance.size(); i++) {
            if (db.instance.get(i).customerID.equals(ID) && db.instance.get(i).customerPassword.equals(customerPW)){

                return getIndex(db, i);
            }
        }
        return -1;
    }

    public int getAccountIndexByUsername(String username, Database db){
        for (int i = 0; i < db.instance.size(); i++) {
            if (db.instance.get(i).customerID.equals(username)){

                return getIndex(db, i);
            }
        }
        return -1;
    }

    private int getIndex(Database db, int i) {
        this.customerID         = db.instance.get(i).customerID;
        this.customerPassword   = db.instance.get(i).customerPassword;
        this.sum                = db.instance.get(i).sum;
        this.name               = db.instance.get(i).name;
        this.surname            = db.instance.get(i).surname;

        return i;
    }

    public Customer createAccount(String uid, String id, String pw, Double amount, Database db){
        for (int i = 0; i < db.instance.size(); i++) {
            if (db.instance.get(i).customerID.equals(id)){
                return null;
            }
        }

        this.customerID         = id;
        this.customerPassword   = pw;
        this.sum                = amount;
        this.customerUID        = uid;
        this.name               = null;
        this.surname            = null;

        //cus.add(this);
        //System.out.println(cus.get(1).customerID);
        //System.out.println(cus.get(1).customerPassword);


        return this;
    }

    public void addAccountToArrayList(){
        System.out.println(this.customerID);
    }
}

