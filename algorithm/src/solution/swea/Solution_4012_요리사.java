package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

    static int N;
    static int[][] synergy;
    static int[] foodA;
    static int result;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            synergy = new int[N][N];
            foodA = new int[N / 2];
            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(1, 1);

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void combination(int cnt, int start) {
        if (cnt == N / 2) {
            calcFlavor();
            return;
        }
        foodA[0] = 0;
        for (int i = start; i < N; i++) {
            foodA[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    private static void calcFlavor() {
        int[] foodB = new int[N/2];
        int sumA = 0;
        int sumB = 0;

        int num = 0;
        for (int i = 0; i  < N; i++) {
            if (Arrays.binarySearch(foodA, i) < 0) {
                foodB[num++] = i;
            }
        }

        for (int i = 0 ; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                sumA += synergy[foodA[i]][foodA[j]];
                sumA += synergy[foodA[j]][foodA[i]];
                sumB += synergy[foodB[i]][foodB[j]];
                sumB += synergy[foodB[j]][foodB[i]];
            }
        }
        result = Math.min(result, Math.abs(sumA - sumB));
    }
}
