package ch02_인터페이스의변화;

/**
 * 1. 인터페이스 기본(default) 메서드와 스태틱(static) 메서드
 */
public interface Foo {

    void printName();

    /**
     * @implSpec
     * 이 구현체는 getName() 으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void printAnything() {
        System.out.println("Anything");
    }
}