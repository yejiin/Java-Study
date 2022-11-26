package com.example.designpatterns._01_creational_patterns._01_singleton.example.classic;

/**
 * 고전적인 싱글턴 패턴 구현법
 */
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}
