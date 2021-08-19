package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1233_사칙연산유효성검사 {

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(in.readLine());
            boolean flag1 = false;
            boolean flag2 = false;
            for (int i = 0; i < N; i++) {
                String[] input = in.readLine().split(" ");
                if (input.length == 4) {
                    if (!"+-*/".contains(input[1])) {
                       flag1 = true;
                    }
                } else if(input.length == 2) {
                    if (!"0123456789".contains(input[1])) {
                        flag2 = true;
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            if (!flag1 && !flag2) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
