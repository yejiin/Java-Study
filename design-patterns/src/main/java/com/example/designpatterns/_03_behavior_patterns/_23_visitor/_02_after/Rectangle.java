package com.example.designpatterns._03_behavior_patterns._23_visitor._02_after;

public class Rectangle implements Shape {

    @Override
    public void accept(Device device) {
        device.print(this);
    }
}
