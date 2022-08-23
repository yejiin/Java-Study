package com.example.designpatterns._02_structural_patterns._06_adapter;

import com.example.designpatterns._02_structural_patterns._06_adapter.security.UserDetails;
import com.example.designpatterns._02_structural_patterns._06_adapter.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

    AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
