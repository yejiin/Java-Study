package com.example.designpatterns._01_creational_patterns._02_factorymethod;

public class WhiteShipFactory extends DefaultShipFactory {

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
