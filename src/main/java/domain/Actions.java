package domain;

import java.util.Objects;

public class Actions {
    public void depositMoney(Customer acc,Double amount){
        acc.setSum(acc.getSum()+amount);
    }

    public void withdrawMoney(Customer acc,Double amount){
        if (acc.getSum() >= amount) {
            acc.setSum(acc.getSum()-amount);
        }
        else {
            System.out.println("Insufficient balance.");
        }


    }

    public void transferMoney(Customer fromAcc, Customer toAcc, Double amount){
        if(!Objects.equals(fromAcc.customerID, toAcc.customerID)) {
            if (fromAcc.getSum() >= amount) {
                withdrawMoney(fromAcc, amount);
                depositMoney(toAcc, amount);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
                System.out.println("You can not transfer money to yourself :)");
        }
    }
}
