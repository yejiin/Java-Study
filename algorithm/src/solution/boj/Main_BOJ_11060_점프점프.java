package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11060_점프점프 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());

        int[] maze = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= maze[i]; j++) {
                if (N <= i + j || dp[i] == Integer.MAX_VALUE) {
                    continue;
                }

                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }
}
