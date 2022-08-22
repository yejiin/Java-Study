package com.example.designpatterns._02_structural_patterns.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
