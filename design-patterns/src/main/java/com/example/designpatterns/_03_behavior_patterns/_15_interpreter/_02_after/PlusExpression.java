package com.example.designpatterns._03_behavior_patterns._15_interpreter._02_after;

import com.example.designpatterns._03_behavior_patterns._15_interpreter._02_after.PostfixExpression;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class PlusExpression implements PostfixExpression {

    private PostfixExpression left;
    private PostfixExpression right;

    @Override
    public int interpret(Map<Character, Integer> context) {
        return left.interpret(context) + right.interpret(context);
    }
}
