package com.example.designpatterns._02_structural_patterns._07_bridge;

public class App {

    public static void main(String[] args) {
        Champion kda아리 = new KDA아리();
        kda아리.skillQ();
        kda아리.skillR();

        // bridge pattern
        Champion kda아리2 = new 아리(new KDA());
        kda아리2.skillQ();
        kda아리2.skillR();

        Champion poolParty아리 = new 아리(new PoolParty());
        poolParty아리.skillQ();
        poolParty아리.skillR();
    }
}
