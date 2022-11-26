package com.example.designpatterns._01_creational_patterns._01_singleton.example.threadsafe;

public class Singleton2 {

    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return uniqueInstance;
    }
}
