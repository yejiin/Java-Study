package com.example.designpatterns._01_creational_patterns._03_abstract_factory._02_after;

import com.example.designpatterns._01_creational_patterns._02_factory_method._02_after.Ship;
import com.example.designpatterns._01_creational_patterns._02_factory_method._02_after.ShipFactory;

public class ShipInventory {

    public static void main(String[] args) {
        ShipFactory shipProFactory = new WhiteShipFactory(new WhiteShipPartsFactory());
        Ship proShip = shipProFactory.createShip();
        System.out.println(proShip.getAnchor().getClass());
        System.out.println(proShip.getWheel().getClass());

        ShipFactory shipFactory = new WhiteShipFactory(new WhiteShipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
