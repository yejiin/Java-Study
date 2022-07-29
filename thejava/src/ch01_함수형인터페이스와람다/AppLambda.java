package ch01_함수형인터페이스와람다;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * 3. 람다 표현식
 */
public class AppLambda {

    public static void main(String[] args) {
        AppLambda app = new AppLambda();
        app.run();
    }

    private void run() {
        final int baseNumber = 10;  // 익명 클래스, 람다에서 사용할 경우 final 생략 가능

        // 지역 클래스 (로컬 변수 참조)
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 (로컬 변수 참조)
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {                    // scope
            @Override                                                                    //
            public void accept(Integer integer) {                                        //
                System.out.println(baseNumber);                                          //
            }                                                                            //
        };                                                                               //

        // 람다 (로컬 변수 참조)
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

//        IntConsumer printInt2 = (baseNumber) -> System.out.println(baseNumber);  // 컴파일 에러(baseNumber 와 같은 scope 이므로 shadowing 되지 않는다.)

        printInt.accept(10);
    }
}
