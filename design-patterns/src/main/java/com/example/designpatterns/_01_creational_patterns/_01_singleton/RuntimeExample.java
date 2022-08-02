package com.example.designpatterns._01_creational_patterns._01_singleton;

public class RuntimeExample {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); // 싱글톤 객체

        // 실행 중인 메모리 정보 확인
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());
    }
}
