package ch01_함수형인터페이스와람다;

/**
 * 1. 함수형 인터페이스와 람다 표현식 소개
 */
public class AppFunctional {

    public static void main(String[] args) {

        // 익명 내부 클래스
       RunSomething runSomething1 = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };
       runSomething1.doIt();

       // 람다 표현식
       RunSomething runSomething2 = () -> System.out.println("Hello");
       runSomething2.doIt();
    }
}
