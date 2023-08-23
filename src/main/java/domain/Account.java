package domain;

import java.util.*;

public class Account {
    String customerID;

    String customerPassword;
    Double sum;

    String name;
    String surname;

    Map<String, String> map = new HashMap<String, String>();
    Map<String, Double> accountInfo = new HashMap<String, Double>();

    public Account() {
        //if (map.get("test").isEmpty())
        if (map.get("test") == null ){
            map.put("test","pw123");
            accountInfo.put("test",232.00);
        }

    }

    public boolean loginAccount(String ID,String customerPW){
        if (Objects.equals(customerPW, map.get(ID))) {
            this.customerID = ID;
            this.customerPassword = customerPW;
            this.sum = accountInfo.get(ID);
            return true;

        }
        else{
            return false;
        }

    }

    public boolean getCredentials(){
        System.out.println("------------------------------------");
        System.out.println("Username: ");
        Scanner scn1 = new Scanner(System.in);
        String username = scn1.nextLine();
        System.out.println("Password: ");
        String password = scn1.nextLine();
        return loginAccount(username,password);
    }

    public boolean createAccount(String id,String pw,Double amount){
        if (map.get(id) == null ){
            map.put(id,pw);
            accountInfo.put(id,amount);
            this.customerID = id;
            this.customerPassword = pw;
            this.sum = amount;
            return true;
        }
        else{
            return false;
        }
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Account(String customerID, String customerPassword, Double sum, String name, String surname) {
        this.customerID = customerID;
        this.customerPassword = customerPassword;
        this.sum = sum;
        this.name = name;
        this.surname = surname;
    }

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
}
