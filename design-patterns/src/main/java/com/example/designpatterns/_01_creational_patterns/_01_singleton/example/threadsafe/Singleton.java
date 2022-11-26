package com.example.designpatterns._01_creational_patterns._01_singleton.example.threadsafe;

public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {}

    /**
     * 동기화는 인스턴스가 생성될 때 이외에는 불필요한 오버헤드만 증가시킬 수 있다.
     *
     * 효율적인 멀티스레딩 문제 해결 방법
     * 1. getInstance() 의 속도가 문제가 되지 않는다면 그대로 사용
     * 2. 처음부터 인스턴스 생성 (Singleton2 클래스)
     * 3. DCL(Double-Checked Locking)을 써서 getInstance() 에서 동기화되는 부분을 줄인다. (Singleton3 클래스)
     */
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }


}
