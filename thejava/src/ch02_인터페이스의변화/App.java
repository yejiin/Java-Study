package ch02_인터페이스의변화;

/**
 * 1. interface - default method, static method
 */
public class App {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("kim");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
