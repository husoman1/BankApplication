package org.example;

public class Actions {
    public void depoitMoney(Account acc,Double amount){
        acc.setSum(acc.getSum()+amount);
        System.out.println(acc.getSum());

    }

    public void withdrawMoney(Account acc,Double amount){
        if (acc.getSum() >= amount) {
            acc.setSum(acc.getSum()-amount);
            System.out.println(acc.getSum());
        }
        else {
            System.out.println("not enough");
        }


    }
}
