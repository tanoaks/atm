package model.account;

public class SavingAccount implements Account {
    public  SavingAccount(double amount){
        this.balance=amount;
    }
    double balance;
    @Override
    public double balance() {
        return balance;
    }

    @Override
    public double debit(double amount) {
        if(balance<amount){
            throw  new RuntimeException("Balance not sufficient");
        }
        return balance-amount;
    }

    @Override
    public double credit(double amount) {
        return balance+amount;
    }
}
