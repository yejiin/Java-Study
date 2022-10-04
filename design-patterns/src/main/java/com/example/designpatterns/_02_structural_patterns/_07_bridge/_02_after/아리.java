package com.example.designpatterns._02_structural_patterns._07_bridge._02_after;

import com.example.designpatterns._02_structural_patterns._07_bridge._02_after.DefaultChampion;
import com.example.designpatterns._02_structural_patterns._07_bridge._02_after.Skin;

public class 아리 extends DefaultChampion {

    public 아리(Skin skin) {
        super(skin, "아리");
    }
}
