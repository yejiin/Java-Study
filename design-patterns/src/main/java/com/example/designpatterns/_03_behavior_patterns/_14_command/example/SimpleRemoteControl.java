package com.example.designpatterns._03_behavior_patterns._14_command.example;

public class SimpleRemoteControl {

    private Command slot;  // 커맨드를 저장할 슬롯

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
