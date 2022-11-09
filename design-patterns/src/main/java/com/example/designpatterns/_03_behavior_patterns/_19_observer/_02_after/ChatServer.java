package com.example.designpatterns._03_behavior_patterns._19_observer._02_after;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {

    private Map<String, List<Observer>> observers = new HashMap<>();

    public void register(String subject, Observer observer) {
        if (this.observers.containsKey(subject)) {
            this.observers.get(subject).add(observer);
        } else {
            List<Observer> list = new ArrayList<>();
            list.add(observer);
            this.observers.put(subject, list);
        }
    }

    public void unregister(String subject, Observer observer) {
        if (this.observers.containsKey(subject)) {
            this.observers.get(subject).remove(observer);
        }
    }

    public void sendMessage(User user, String subject, String message) {
        if (this.observers.containsKey(subject)) {
            String userMessage = user.getName() + ": " + message;
            this.observers.get(subject).forEach(s -> s.handleMessage(userMessage));
        }
    }
}
