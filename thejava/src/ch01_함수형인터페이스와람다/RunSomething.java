package ch01_함수형인터페이스와람다;

/**
 * 함수형 인터페이스 (Functional Interface)
 * 추상 메서드를 하나만 가지고 있는 인터페이스
 * @FunctionalInterface 생략 가능
 */
public interface RunSomething {

    void doIt();  // abstract 생략

    static void printName() {
        System.out.println("kim");
    }

    default void printAge() {
        System.out.println("20");
    }
}
