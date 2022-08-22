package com.example.designpatterns._02_structural_patterns;

import com.example.designpatterns._02_structural_patterns.security.UserDetails;
import com.example.designpatterns._02_structural_patterns.security.UserDetailsService;

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
