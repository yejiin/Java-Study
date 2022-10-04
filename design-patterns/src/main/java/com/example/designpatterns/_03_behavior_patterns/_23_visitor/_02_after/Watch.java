package com.example.designpatterns._03_behavior_patterns._23_visitor._02_after;

public class Watch implements Device {

    @Override
    public void print(Circle circle) {
        System.out.println("Print Circle to Watch");
    }

    @Override
    public void print(Rectangle rectangle) {
        System.out.println("Print Rectangle to Watch");
    }

}
