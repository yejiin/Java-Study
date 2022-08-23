package com.example.designpatterns._02_structural_patterns._06_adapter.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
