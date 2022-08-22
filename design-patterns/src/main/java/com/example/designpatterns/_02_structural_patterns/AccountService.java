package com.example.designpatterns._02_structural_patterns;

public class AccountService {

    public Account findAccountByUsername(String username) {
        Account account = new Account();
        account.setName(username);
        account.setPassword(username);
        account.setEmail(username);
        return account;
    }

    public void creatqeNewAccount(Account account) {

    }

        public void updateAccount(Account account) {

    }
}
