package com.example.designpatterns._03_behavior_patterns._13_chain_of_responsibilities._02_after;

import com.example.designpatterns._03_behavior_patterns._13_chain_of_responsibilities._01_before.Request;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class RequestHandler {

    private RequestHandler nextHandler;

    public void handle(Request request) {
        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }
}
