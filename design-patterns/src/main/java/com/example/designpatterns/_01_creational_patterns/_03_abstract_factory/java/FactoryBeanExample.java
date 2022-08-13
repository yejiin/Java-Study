package com.example.designpatterns._01_creational_patterns._03_abstract_factory.java;

import com.example.designpatterns._01_creational_patterns._02_factorymethod.Ship;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanExample {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
//        Ship whiteship = applicationContext.getBean("whiteship", Ship.class);
//        System.out.println(whiteship.getName());

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        ShipFactory bean = applicationContext.getBean(ShipFactory.class);
        System.out.println(bean);
        Ship ship = applicationContext.getBean(Ship.class);
        System.out.println(ship);
    }
}
