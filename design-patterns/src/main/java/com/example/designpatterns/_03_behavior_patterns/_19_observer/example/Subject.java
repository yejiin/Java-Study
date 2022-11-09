package com.example.designpatterns._03_behavior_patterns._19_observer.example;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
