package com.example.designpatterns._03_behavior_patterns._22_template_method._02_after;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Multiply("number.txt");

        int result = fileProcessor.process((sum, number) -> sum + number);
        System.out.println(result);
    }
}
