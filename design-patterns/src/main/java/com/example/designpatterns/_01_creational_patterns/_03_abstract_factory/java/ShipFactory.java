package com.example.designpatterns._01_creational_patterns._03_abstract_factory.java;

import com.example.designpatterns._01_creational_patterns._02_factorymethod.Ship;
import com.example.designpatterns._01_creational_patterns._02_factorymethod.WhiteShip;
import org.springframework.beans.factory.FactoryBean;

public class ShipFactory implements FactoryBean<Ship> {

    @Override
    public Ship getObject() throws Exception {
        Ship ship = new WhiteShip();
        ship.setName("whiteship");
        return ship;
    }

    @Override
    public Class<?> getObjectType() {
        return Ship.class;
    }
}
