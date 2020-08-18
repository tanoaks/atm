package model;

import model.account.Account;

public class User {

   private Account account;
   public User(Account account){
       this.account=account;
   }

    public Account getAccount() {
        return account;
    }
}
