package com.example.designpatterns._03_behavior_patterns._17_mediator._01_before;

public class Gym {

    private CleaningService cleaningService = new CleaningService();

    public void clean() {
        cleaningService.clean(this);
    }

}
