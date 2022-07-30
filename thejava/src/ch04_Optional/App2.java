package ch04_Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App2 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));


        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present);  // true

        boolean empty = optional.isEmpty();
        System.out.println(empty);  // false

        OnlineClass onlineClass = optional.get();  // optional 이 없는 경우 NoSuchElementException 발생
        System.out.println(onlineClass.getTitle());  // spring boot

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));  // spring boot

        OnlineClass onlineClass1 = optional.orElse(createNewClass());  // createNewClass 메서드 무조건 실행
        System.out.println(onlineClass1.getTitle());

        OnlineClass onlineClass2 = optional.orElseGet(App2::createNewClass);  // optional 이 없는 경우 createNewClass 메서드 실행 X
        System.out.println(onlineClass2.getTitle());

        OnlineClass onlineClass3 = optional.orElseThrow(IllegalAccessError::new);
        System.out.println(onlineClass3.getTitle());

        Optional<OnlineClass> onlineClass4 = optional.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass4.isEmpty());  // true

        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}