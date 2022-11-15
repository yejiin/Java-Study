package com.example.designpatterns._02_structural_patterns._09_decorator.example.io;

import java.io.*;

public class InputTest {

    public static void main(String[] args) throws IOException {
        int c;
        InputStream in = null;
        try {
            in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) in.close();
        }
    }
}
