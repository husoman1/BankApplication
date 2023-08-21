package org.example;

import java.util.*;

public class Account {
    String customerID;

    String customerPassword;

    Map<String, String> map = new HashMap<String, String>();
    Map<String, Double> accountInfo = new HashMap<String, Double>();

    public Account() {
        map.put("test","pw123");
        accountInfo.put("test",232.00);
    }

    public boolean loginAccount(String ID,String customerPW){
        if (Objects.equals(customerPW, map.get(ID))) {
            this.customerID = ID;
            return true;

        }
        else{
            return false;
        }

    }

    public boolean getCredentials(){
        System.out.println("Customer ID Please");
        Scanner scn1 = new Scanner(System.in);
        String input1 = scn1.nextLine();
        System.out.println("Customer PW Please");
        String input2 = scn1.nextLine();
        return loginAccount(input1,input2);
    }

    public Double getSum(String ID) {
        return accountInfo.get(ID);
    }
}
