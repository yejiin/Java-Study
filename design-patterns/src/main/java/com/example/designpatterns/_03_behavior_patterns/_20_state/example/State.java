package com.example.designpatterns._03_behavior_patterns._20_state.example;

public interface State {

    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();

    public void refill();
}
