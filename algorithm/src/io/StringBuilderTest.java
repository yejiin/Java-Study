package io;

/*
  StringBuilder
  문자열(String)을 조작 시 새로운 문자열이 생성되는 것을 방지
 */
public class StringBuilderTest {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        sb.append("Hi!!");

        sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());

    }
}
