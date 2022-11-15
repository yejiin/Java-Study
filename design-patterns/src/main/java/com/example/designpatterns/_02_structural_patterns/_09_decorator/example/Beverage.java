package com.example.designpatterns._02_structural_patterns._09_decorator.example;

/**
 * 추상 구성 요소
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
