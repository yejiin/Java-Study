package com.example.designpatterns._02_structural_patterns.java;

import java.io.*;
import java.util.*;

public class AdapterInJava {

    public static void main(String[] args) {
        // collections
        List<String> strings = Arrays.asList("a", "b", "c"); // 배열 -> 리스트
        Enumeration<String> enumeration = Collections.enumeration(strings);  // 리스트 -> enumeration
        ArrayList<String> list = Collections.list(enumeration);  // enumeration -> 리스트

        // io
        try (InputStream is = new FileInputStream("input.txt");
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader reader = new BufferedReader(isr)) {

            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
