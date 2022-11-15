package com.example.designpatterns._02_structural_patterns._09_decorator.example;

/**
 * 추상 데코레이터
 */
public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}
