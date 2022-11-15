package com.example.designpatterns._02_structural_patterns._09_decorator.example;

/**
 * 구상 데코레이터
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.description + ", Mocha";
    }
}
