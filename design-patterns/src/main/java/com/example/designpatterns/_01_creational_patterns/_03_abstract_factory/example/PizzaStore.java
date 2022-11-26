package com.example.designpatterns._01_creational_patterns._03_abstract_factory.example;

public abstract class PizzaStore {

    protected abstract Pizza createPizza(String name);

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
