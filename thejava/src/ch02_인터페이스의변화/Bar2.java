package ch02_인터페이스의변화;

public interface Bar2 {

    default void printNameUpperCase() {
        System.out.println("BAR");
    }
}
