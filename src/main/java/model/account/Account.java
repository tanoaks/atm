package model.account;

public interface Account {

    double balance();
    double debit(double amount);
    double credit(double amount);


}
