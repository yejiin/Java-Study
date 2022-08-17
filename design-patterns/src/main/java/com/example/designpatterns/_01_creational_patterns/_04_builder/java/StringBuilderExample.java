package com.example.designpatterns._01_creational_patterns._04_builder.java;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String result = stringBuilder.append("abc").append("def").toString();
        System.out.println(result);
    }
}
