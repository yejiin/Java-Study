package com.example.designpatterns._01_creational_patterns._03_abstract_factory;

import com.example.designpatterns._01_creational_patterns._02_factorymethod.Ship;
import com.example.designpatterns._01_creational_patterns._02_factorymethod.ShipFactory;

public class ShipInventory {

    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteshipFactory(new WhitePartsProFactory());
//        ShipFactory shipFactory = new WhiteshipFactory(new WhiteshipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
