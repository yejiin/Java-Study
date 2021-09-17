package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2 {

    public static void main(String[] args) throws Exception {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (i != j && num == 0) {
                        map[i][j] = N * N;
                    } else {
                        map[i][j] = num;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            int minSum = Arrays.stream(map[0]).sum();
            for (int i = 1; i < N; i++) {
                minSum = Math.min(minSum, Arrays.stream(map[i]).sum());
            }

            sb.append("#").append(tc).append(" ").append(minSum).append("\n");
        }
        System.out.println(sb);
    }
}