package com.example.designpatterns._01_creational_patterns._01_singleton;

/**
 * 싱글톤 패턴을 가장 단순하게 구현
 * private 생성자와 public static 메서드를 사용하는 방법
 * thread safe 하지 않다.
*/
public class Settings1 {

    private static Settings1 instance;

    private Settings1() {}

    public static Settings1 getInstance() {
        if (instance == null) {
            instance = new Settings1();
        }

        return instance;
    }
}
