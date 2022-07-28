package ch02_인터페이스의변화;

public class Main1 {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("kim");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
