package com.example.designpatterns._02_structural_patterns._06_adapter._02_after;

import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.Account;
import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.AccountService;
import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.security.UserDetails;
import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.security.UserDetailsService;
import com.example.designpatterns._02_structural_patterns._06_adapter._02_after.AccountUserDetails;

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
