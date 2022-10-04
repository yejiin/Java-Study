package com.example.designpatterns._03_behavior_patterns._15_interpreter._02_after;

import java.util.Map;

public interface PostfixExpression {

    int interpret(Map<Character, Integer> context);
}
