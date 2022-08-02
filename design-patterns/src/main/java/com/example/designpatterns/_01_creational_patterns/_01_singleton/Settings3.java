package com.example.designpatterns._01_creational_patterns._01_singleton;

/**
 * 멀티 쓰레드 환경에서 안전하게 구현하는 방법 2
 * 이른 초기화(eager initialization) 사용하기
 * 미리 인스턴스를 만들어 놓는 것이 단점이 될 수 있음
*/
public class Settings3 {

    private static final Settings3 INSTANCE = new Settings3();

    private Settings3() {}

    public static Settings3 getInstance() {
        return INSTANCE;
    }
}
