package com.example.designpatterns._01_creational_patterns._04_builder._03_java;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SpringExample {

    public static void main(String[] args) {
        UriComponents howToStudyJava = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("www.study.me")
                .path("java-playlist-ep1")
                .build().encode();
        System.out.println(howToStudyJava);
    }
}
