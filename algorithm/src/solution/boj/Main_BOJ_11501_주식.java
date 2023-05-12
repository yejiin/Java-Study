package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_11501_주식 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(in.readLine());
            int[] arr = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long result = 0;  // 숫자 데이터 타입 범위 주의
            int max = 0;
            for (int i = N - 1; i >= 0; i--) {  // 역순 조회가 핵심
                if (arr[i] > max) {
                    max = arr[i];
                } else {
                    result += max - arr[i];
                }
            }
            System.out.println(result);
        }
    }
}
