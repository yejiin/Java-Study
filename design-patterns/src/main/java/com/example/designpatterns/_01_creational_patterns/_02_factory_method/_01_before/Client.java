package com.example.designpatterns._01_creational_patterns._02_factory_method._01_before;

public class Client {

    public static void main(String[] args) {
        Ship whiteship = ShipFactory.orderShip("Whiteship", "whiteship@mail.com");
        System.out.println(whiteship);

        Ship blackship = ShipFactory.orderShip("Blackship", "blackship@mail.com");
        System.out.println(blackship);
    }

}
