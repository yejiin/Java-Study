package com.example.designpatterns._01_creational_patterns._01_singleton;

/**
 * 멀티 쓰레드 환경에서 안전하게 구현하는 방법 3
 * double checked locking 사용하기
*/
public class Settings4 {

    private static volatile Settings4 instance;

    private Settings4() {}

    public static Settings4 getInstance() {
        if (instance == null) {
            synchronized (Settings1.class) {
                if (instance == null) {
                    instance = new Settings4();
                }
            }
        }
        return instance;
    }
}
