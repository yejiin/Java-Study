package com.example.designpatterns._03_behavior_patterns._18_memento._01_before;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Game implements Serializable {

    private int redTeamScore;

    private int blueTeamScore;
}
