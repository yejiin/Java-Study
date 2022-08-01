package com.example.designpatterns._01_creational_patterns._01_singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) {
        Settings1 settings = Settings1.getInstance();
        System.out.println(settings == Settings1.getInstance());

    }
}
