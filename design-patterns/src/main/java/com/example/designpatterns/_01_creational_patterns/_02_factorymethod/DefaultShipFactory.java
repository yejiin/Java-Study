package com.example.designpatterns._01_creational_patterns._02_factorymethod;

// 자바 8 version
public abstract class DefaultShipFactory implements ShipFactory{

    @Override
    public void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }
}
