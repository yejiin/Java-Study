package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  BufferedReader
  1. 줄(line) 단위로 문자열 처리 -> readLine()
  2. 대량의 데이터 처리 시 효율적인 수행 시간
  3. String 데이터를 char[] 배열이나 StringTokenizer를 사용하여 처리
 */
public class BufferedReaderTest {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // char 배열
        String str = in.readLine();
        char ch[] = str.toCharArray();
        for (char c : ch) {
            System.out.println(c);
        }

        // StringTokenizer
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        System.out.println(i + ", " + j);
    }
}
