package com.example.designpatterns._03_behavior_patterns._22_template_method.example;

public abstract class CaffeineBeverage {

    /**
     * 탬플릿 메소드
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCut();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCut() {
        System.out.println("Pouring into cup");
    }
}
