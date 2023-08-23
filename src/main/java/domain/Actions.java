package domain;

public class Actions {
    public void depositMoney(Customer acc,Double amount){
        acc.setSum(acc.getSum()+amount);
        System.out.println(acc.getSum());

    }

    public void withdrawMoney(Customer acc,Double amount){
        if (acc.getSum() >= amount) {
            acc.setSum(acc.getSum()-amount);
            System.out.println(acc.getSum());
        }
        else {
            System.out.println("not enough");
        }


    }
}
