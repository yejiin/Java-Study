package ch01_함수형인터페이스와람다;

import java.util.function.*;

/**
 * 2. 자바에서 제공하는 함수형 인터페이스
 */
public class Main2 {

    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2));
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMultiply2.apply(2));


        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);


        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());


        Predicate<String> startsWithK = (s) -> s.startsWith("K");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;


        UnaryOperator<Integer> p10 = (i) -> i + 10;
        UnaryOperator<Integer> multi2 = (i) -> i * 2;
    }
}
