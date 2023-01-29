package com.example.designpatterns._03_behavior_patterns._20_state._02_after;

public class Client {
    public static void main(String[] args) {
        OnlineCourse onlineCourse = new OnlineCourse();
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");
        s2.addPrivate(onlineCourse);

        onlineCourse.addStudent(s1);

        onlineCourse.changeState(new Private(onlineCourse));

        onlineCourse.addReview("hello", s1);

        onlineCourse.addStudent(s2);

        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getReviews());
        System.out.println(onlineCourse.getStudents());
    }
}
