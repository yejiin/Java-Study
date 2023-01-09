package com.example.designpatterns._03_behavior_patterns._14_command.example;

// 클라이언트
public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();  // invoker 역할
        Light light = new Light();  // receiver (요청 처리)
        LightOnCommand lightOn = new LightOnCommand(light);  // command 객체 (리시버 전달)

        remote.setCommand(lightOn);  // invoker 에 command 객체 전달
        remote.buttonWasPressed();


        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }
}
