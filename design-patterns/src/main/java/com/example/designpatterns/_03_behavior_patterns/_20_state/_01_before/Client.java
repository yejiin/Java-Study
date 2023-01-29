package com.example.designpatterns._03_behavior_patterns._20_state._01_before;

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student("s1");
        OnlineCourse onlineCourse = new OnlineCourse();

        Student s2 = new Student("s2");
        s2.addPrivateCourse(onlineCourse);

        onlineCourse.addStudent(s1);
        onlineCourse.changeState(OnlineCourse.State.PRIVATE);

        onlineCourse.addStudent(s2);

        onlineCourse.addReview("hello", s1);

        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getStudents());
        System.out.println(onlineCourse.getReviews());
    }
}

