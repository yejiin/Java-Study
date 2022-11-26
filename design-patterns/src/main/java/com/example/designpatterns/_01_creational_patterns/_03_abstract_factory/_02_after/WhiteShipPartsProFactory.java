package com.example.designpatterns._01_creational_patterns._03_abstract_factory._02_after;

public class WhiteShipPartsProFactory implements ShipPartsFactory {
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchorPro();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheelPro();
    }
}
