package com.example.designpatterns._03_behavior_patterns._17_mediator._02_after;

import java.time.LocalDateTime;

public class Restaurant {

    private FrontDesk frontDesk = new FrontDesk();

    public void dinner(Integer id, LocalDateTime dateTime) {
        frontDesk.dinner(id, dateTime);
    }
}
