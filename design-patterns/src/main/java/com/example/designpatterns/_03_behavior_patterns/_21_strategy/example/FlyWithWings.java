package com.example.designpatterns._03_behavior_patterns._21_strategy.example;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        // 오리가 나는 것을 구현
        System.out.println("오리 날다");
    }
}
