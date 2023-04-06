package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP - top down(재귀)
 */
public class Main_BOJ_2579_계단오르기 {
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        arr = new int[N + 1];
        dp = new Integer[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));
    }
    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + arr[n - 1]) + arr[n];
        }

        return dp[n];
    }
}
