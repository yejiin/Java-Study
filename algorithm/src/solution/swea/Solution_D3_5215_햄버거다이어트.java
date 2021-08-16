package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {

    static boolean[] isSelected;

    static int[] T; // 점수
    static int[] K; // 칼로리

    static int N;
    static int L;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            T = new int[N];
            K = new int[N];

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(in.readLine(), " ");
                T[n] = Integer.parseInt(st.nextToken());
                K[n] = Integer.parseInt(st.nextToken());
            }

            isSelected = new boolean[N];
            result = 0;

            subSet(0);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void subSet(int cnt) {

        if (cnt == N) {

            int sumT = 0;
            int sumK = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    sumT += T[i];
                    sumK += K[i];
                }
            }

            if (sumK <= L) {
                result = Math.max(result, sumT);
            }
            return;
        }

        isSelected[cnt] = true;
        subSet(cnt + 1);
        isSelected[cnt] = false;
        subSet(cnt + 1);

    }
}