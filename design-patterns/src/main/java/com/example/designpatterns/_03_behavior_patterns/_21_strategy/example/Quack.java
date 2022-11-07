package com.example.designpatterns._03_behavior_patterns._21_strategy.example;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        // 꽥꽥 소리 내는 것을 구현
        System.out.println("꽥 꽥");
    }
}
