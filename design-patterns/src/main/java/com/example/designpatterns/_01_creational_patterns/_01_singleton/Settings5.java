package com.example.designpatterns._01_creational_patterns._01_singleton;

import java.io.Serializable;

/**
 * 멀티 쓰레드 환경에서 안전하게 구현하는 방법 4 - 권장하는 방법 중 하나
 * static inner 클래스 사용하기
*/
public class Settings5 {

    private Settings5() {}

    private static class SettingsHolder {
        private static final Settings5 INSTANCE = new Settings5();
    }

    public static Settings5 getInstance() {
        return SettingsHolder.INSTANCE;
    }

}
