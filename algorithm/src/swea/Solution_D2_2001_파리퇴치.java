package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치 {

    public static void main(String[] args) throws NumberFormatException, IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        int N = 0, M = 0;
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] area = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxCnt = 0;
            int cnt = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            cnt += area[k][l];
                        }
                    }
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 0;
                }

            }
            sb.append(maxCnt).append("\n");
        }
        System.out.println(sb);
    }
}
