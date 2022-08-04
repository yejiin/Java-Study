package com.example.designpatterns._01_creational_patterns._02_factorymethod;

public class WhiteShipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }


}
