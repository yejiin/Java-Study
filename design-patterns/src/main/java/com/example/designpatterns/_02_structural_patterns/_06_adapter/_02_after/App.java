package com.example.designpatterns._02_structural_patterns._06_adapter._02_after;

import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.AccountService;
import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.security.LoginHandler;
import com.example.designpatterns._02_structural_patterns._06_adapter._01_before.security.UserDetailsService;
public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("kim", "kim");
        System.out.println(login);
    }
}
