package ch07_Etc;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER)  // 타입 변수에만 사용 가능
@Target(ElementType.TYPE_USE)  // 타입 변수를 포함해서 모든 타입 선언부에 사용 가능
@Repeatable(ReChickenContainer.class)  // 중복 가능
public @interface ReChicken {
    String value();
}
