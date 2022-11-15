package com.example.designpatterns._01_creational_patterns._02_factory_method.example;

public class ChicagoPizzaStore extends PizzaStore {

    Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}