package com.example.designpatterns._03_behavior_patterns._22_template_method._02_after;

public class Multiply extends FileProcessor {

    public Multiply(String path) {
        super(path);
    }

    @Override
    protected int getResult(int result, int number) {
        return result *= number;
    }

}
