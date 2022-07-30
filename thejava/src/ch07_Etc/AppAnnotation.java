package ch07_Etc;

import java.util.Arrays;
import java.util.List;

/**
 * annotation 의 변화
 * - 타입 선언부에 사용 가능
 */
@Chicken
@ReChicken("양념")
@ReChicken("마늘간장")
public class AppAnnotation {

    public static void main(String[] args) throws @Chicken RuntimeException {
        List<@Chicken String> names = Arrays.asList("kim");

        ReChicken[] reChickens = AppAnnotation.class.getAnnotationsByType(ReChicken.class);
        Arrays.stream(reChickens).forEach(c -> {
            System.out.println(c.value());
        });

        ReChickenContainer reChickenContainer = AppAnnotation.class.getAnnotation(ReChickenContainer.class);
        Arrays.stream(reChickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

    static class FeelsLikeChicken<@Chicken  T> {

        public static <@Chicken C> void print(@Chicken C c) {
            System.out.println(c);
        }
    }
}
