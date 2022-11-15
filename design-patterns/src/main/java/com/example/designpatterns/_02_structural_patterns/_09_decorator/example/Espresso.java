package com.example.designpatterns._02_structural_patterns._09_decorator.example;

/**
 * 구상 구성 요소
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
