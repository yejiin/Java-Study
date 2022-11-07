package com.example.designpatterns._03_behavior_patterns._21_strategy.example;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        // 물오리 모양 표시
        System.out.println("물오리 모양");
    }
}
