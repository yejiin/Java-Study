package com.example.designpatterns._03_behavior_patterns._22_template_method._02_after;

public class Plus implements Operator {
    @Override
    public int getResult(int result, int number) {
        return result += number;
    }
}
