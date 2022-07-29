package ch02_인터페이스의변화;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * 2. Java 8 API default method, static method
 */
public class AppJava8 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("a");
        name.add("b");
        name.add("c");
        name.add("d");


        name.forEach((s) -> {
            System.out.println(s);
        });
        //  ==
        name.forEach(System.out::println);  // -> 메서드 레퍼런스 사용
        //  ==
        for (String n : name) {
            System.out.println(n);
        }


        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("===========");
        while (spliterator1.tryAdvance(System.out::println));


        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .count();
        System.out.println(k);


        name.removeIf(s -> s.startsWith("a"));


        name.sort(String::compareToIgnoreCase);

    }
}
