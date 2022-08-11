package com.example.designpatterns._01_creational_patterns._03_abstract_factory;

public interface ShipPartsFactory {

    Anchor createAnchor();

    Wheel createWheel();
}
