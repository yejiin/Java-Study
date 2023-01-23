package com.example.designpatterns._02_structural_patterns._06_adapter._01_before;

import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.Account;
import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.security.UserDetails;
import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.security.UserDetailsService;

public class AccountService {

    public Account findAccountByUsername(String username) {
        Account account = new Account();
        account.setName(username);
        account.setPassword(username);
        account.setEmail(username);
        return account;
    }

    public void createNewAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }
}