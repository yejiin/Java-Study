package com.example.designpatterns._01_creational_patterns._05_prototype.java;

import java.util.ArrayList;
import java.util.List;

public class JavaCollectionExample {

    public static void main(String[] args) {

        Student s1 = new Student("s1");
        Student s2 = new Student("s2");

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        ArrayList<Student> clone = (ArrayList<Student>) students.clone();
        System.out.println(clone);

        List<Student> clone2 = new ArrayList<>(students);
        System.out.println(clone2);
    }
}