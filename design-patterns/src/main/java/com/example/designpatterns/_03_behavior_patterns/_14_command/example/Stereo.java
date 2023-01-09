package com.example.designpatterns._03_behavior_patterns._14_command.example;

public class Stereo {

    private int volume;

    public void on() {
        System.out.println("Stereo on");
    }

    public void off() {
        System.out.println("Stereo off");
    }

    public void setCd() {
        System.out.println("Stereo setCd");
    }

    public void setDvd() {
        System.out.println("Stereo setDvd");
    }

    public void setRadio() {
        System.out.println("Stereo setRadio");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Stereo setVolume " + volume);
    }
}
