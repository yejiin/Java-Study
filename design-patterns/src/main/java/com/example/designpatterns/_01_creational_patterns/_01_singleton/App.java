package com.example.designpatterns._01_creational_patterns._01_singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Settings1 settings = Settings1.getInstance();
        System.out.println(settings == Settings1.getInstance());


        Settings5 settings5 = Settings5.getInstance();

        /**
         * 싱글톤 패턴 구현을 깨트리는 방법 1
         * 리플렉션 사용하기 (새로운 인스턴스를 만든 것과 비슷)
         * 대응 X
         */
        Constructor<Settings5> constructor = Settings5.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings5 settings51 = constructor.newInstance();

        System.out.println(settings5 == settings51);

        /**
         * 싱글톤 패턴 구현을 깨트리는 방법 2
         * 직렬화 & 역직렬화 사용하환
         * 대응 - readResolve()
         */
        Settings5 settings52 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings5);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings52 = (Settings5) in.readObject();
        }

        System.out.println(settings5 == settings52);


        /**
         * enum 타입은 reflection 에서 new instance 를 생성하지 못함
         * (오류 발생)
         */
        Settings6 settings6 = Settings6.INSTANCE;

        Settings6 settings61 = null;
        Constructor<?>[] declaredConstructors = Settings6.class.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            declaredConstructor.setAccessible(true);
            settings61 = (Settings6) declaredConstructor.newInstance("INSTANCE");
        }
        System.out.println(settings6 == settings61);
    }
}
