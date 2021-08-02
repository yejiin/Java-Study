package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 Scanner
 1. 데이터 형변환 기능 제공
 2. 대량의 데이터 처리 시 비효율적인 수행시간 발생
 */
public class ScannerTest {

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);  // System.in :: 표준 입력

        System.out.println("정수, 실수, 문자열, 문자열을 차례로 입력하세요 : ");

        System.out.println("정수 : " + sc.nextInt());
        System.out.println("실수 : " + sc.nextDouble());
        System.out.println("문자열 : " + sc.next());
        System.out.println("문자열 : " + sc.nextLine());  // next() 와 다르게 문자열 안에 띄워쓰기 할 수 있음

        int no = sc.nextInt();
        // sc.nextLine();
        String msg = sc.nextLine();  // 앞 공백문자(white space)를 처리하기 위해 sc.nextLine()를 사용
        System.out.println(no + ", " + msg);

    }
}
