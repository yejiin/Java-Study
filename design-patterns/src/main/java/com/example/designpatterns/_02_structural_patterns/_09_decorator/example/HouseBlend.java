package com.example.designpatterns._02_structural_patterns._09_decorator.example;

/**
 * 구상 구성 요소
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "하우스 블렌드 커피";
    }

    @Override
    public double cost() {
        return .89;
    }
}
