package com.example.designpatterns._02_structural_patterns;

import com.example.designpatterns._02_structural_patterns.security.LoginHandler;
import com.example.designpatterns._02_structural_patterns.security.UserDetailsService;

public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("kim", "kim");
        System.out.println(login);
    }
}
