package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int bag5Cnt = N / 5;
        int bag3Cnt = 0;
        int n = N % 5;
        boolean flag = false;
        for (int i = bag5Cnt; i >= 0; i--) {
            n = N - 5 * i;
            if (n % 3 != 0) {
                n = N;
            } else {
                bag3Cnt = n / 3;
                bag5Cnt = i;
                n -= 3 * bag3Cnt;
                break;
            }
        }

        if (n != 0) {
            System.out.println(-1);
        } else {
            System.out.println(bag5Cnt + bag3Cnt);
        }

    }

}