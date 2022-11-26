package com.example.designpatterns._01_creational_patterns._01_singleton.example.classic;

public class SingletonClient {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);
    }
}
