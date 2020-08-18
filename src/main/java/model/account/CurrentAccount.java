package model.account;

public class CurrentAccount implements Account {

    double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double balance() {
        return balance;
    }

    @Override
    public double debit(double amount) {
        if (balance < amount) {
            throw new RuntimeException("Balance not sufficient");
        }
        return balance - amount;
    }

    @Override
    public double credit(double amount) {
        return balance + amount;
    }
}
