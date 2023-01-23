package com.example.designpatterns._02_structural_patterns._06_adapter.example;

import java.util.Random;

public class DuckAdapter implements Turkey {
    private Duck duck;
    private Random rand;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
        rand = new Random();
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        if (rand.nextInt(5) == 0) {
            duck.fly();
        }
    }
}
