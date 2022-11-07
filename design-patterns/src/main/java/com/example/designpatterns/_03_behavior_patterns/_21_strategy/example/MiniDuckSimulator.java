package com.example.designpatterns._03_behavior_patterns._21_strategy.example;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        mallard.display();
        mallard.swim();
    }
}
