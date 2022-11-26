package com.example.designpatterns._01_creational_patterns._03_abstract_factory.example;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
}
