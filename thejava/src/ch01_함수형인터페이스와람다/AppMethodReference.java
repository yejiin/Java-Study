package ch01_함수형인터페이스와람다;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 4. 메서드 레퍼런스
 */
public class AppMethodReference {

    public static void main(String[] args) {

        UnaryOperator<String> hi = (s) -> "hi " + s;

        // static method 참조
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi2.apply("kim"));

        // instance method 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("kim"));

        // 생성자 method 참조
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting newGreeting = greetingSupplier.get();

        // 위와 서로 다른 생성자 참조 (파라미터가 있는 생성자)
        Function<String, Greeting> greetingFunction = Greeting::new;
        Greeting kim = greetingFunction.apply("kim");
        System.out.println(kim.getName());


        // 임의 객체의 **인스턴스 메서드** 참조
        String[] names = {"Z", "D", "A"};
        Arrays.sort(names, new Comparator<String>() {  // @FunctionalInterface
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        // -> 메서드  레퍼런스
        Arrays.sort(names, String::compareToIgnoreCase);

    }
}
