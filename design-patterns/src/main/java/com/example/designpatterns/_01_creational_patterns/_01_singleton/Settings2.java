package com.example.designpatterns._01_creational_patterns._01_singleton;

/**
 * 멀티 쓰레드 환경에서 안전하게 구현하는 방법 1
 * synchronized 키워드 사용
 * 성능 저하 발생 가능
*/
public class Settings2 {

    private static Settings2 instance;

    private Settings2() {}

    public static synchronized Settings2 getInstance() {
        if (instance == null) {
            instance = new Settings2();
        }

        return instance;
    }
}
