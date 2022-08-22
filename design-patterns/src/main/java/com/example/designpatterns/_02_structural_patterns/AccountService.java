package com.example.designpatterns._02_structural_patterns;

import com.example.designpatterns._02_structural_patterns.security.UserDetails;
import com.example.designpatterns._02_structural_patterns.security.UserDetailsService;

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
