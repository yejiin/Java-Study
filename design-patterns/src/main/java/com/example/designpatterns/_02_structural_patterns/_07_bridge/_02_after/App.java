package com.example.designpatterns._02_structural_patterns._07_bridge._02_after;

import com.example.designpatterns._02_structural_patterns._07_bridge._01_before.Champion;

public class App {

    public static void main(String[] args) {
        Champion kda아리 = new 아리(new KDA());
        kda아리.skillQ();
        kda아리.skillR();

        Champion poolParty아리 = new 아리(new PoolParty());
        poolParty아리.skillQ();
        poolParty아리.skillR();
    }
}
