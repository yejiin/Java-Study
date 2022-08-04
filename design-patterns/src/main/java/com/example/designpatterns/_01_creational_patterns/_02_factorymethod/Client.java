package com.example.designpatterns._01_creational_patterns._02_factorymethod;

public class Client {

    public static void main(String[] args) {

        Ship whiteShip = ShipFactory.orderShip("WhiteShip", "kim@mail.com");
        System.out.println(whiteShip);

        Ship blackShip = ShipFactory.orderShip("blackShip", "kim@mail.com");
        System.out.println(blackShip);
    }
}
