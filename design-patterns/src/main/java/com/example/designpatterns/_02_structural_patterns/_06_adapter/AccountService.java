package com.example.designpatterns._02_structural_patterns._06_adapter;

import com.example.designpatterns._02_structural_patterns._06_adapter.security.UserDetails;
import com.example.designpatterns._02_structural_patterns._06_adapter.security.UserDetailsService;

public class AccountService implements UserDetailsService {

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

    @Override
    public UserDetails loadUser(String username) {
        return findAccountByUsername(username);
    }
}
