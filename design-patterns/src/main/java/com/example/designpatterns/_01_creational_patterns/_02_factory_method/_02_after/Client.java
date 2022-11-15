package com.example.designpatterns._01_creational_patterns._02_factory_method._02_after;

public class Client {

    public static void main(String[] args) {

        Ship whiteShip = new WhiteShipFactory().orderShip("WhiteShip", "kim@mail.com");
        System.out.println(whiteShip);

        Ship blackShip = new BlackShipFactory().orderShip("blackShip", "kim@mail.com");
        System.out.println(blackShip);


        Client client = new Client();
        client.print(new WhiteShipFactory(), "whiteship", "ship@mail.com");
        client.print(new BlackShipFactory(), "blackship", "ship@mail.com");
    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
