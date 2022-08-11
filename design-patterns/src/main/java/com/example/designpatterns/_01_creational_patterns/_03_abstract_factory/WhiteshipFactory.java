package com.example.designpatterns._01_creational_patterns._03_abstract_factory;

import com.example.designpatterns._01_creational_patterns._02_factorymethod.DefaultShipFactory;
import com.example.designpatterns._01_creational_patterns._02_factorymethod.Ship;
import com.example.designpatterns._01_creational_patterns._02_factorymethod.WhiteShip;

public class WhiteshipFactory extends DefaultShipFactory {

    private ShipPartsFactory shipPartsFactory;

    public WhiteshipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
