package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서 {

    static int N, M, map[][];
    static int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(in.readLine());
            M = Integer.parseInt(in.readLine());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(map[i], INF);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int s = Integer.parseInt(st.nextToken()) - 1;
                int e = Integer.parseInt(st.nextToken()) - 1;
                map[s][e] = 1;
            }

            // 플로이드 워셜
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            int[] knowCnt = new int[N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 987654321) {
                        knowCnt[i]++; // i 자신보다 큰 j 를 알고 잇는 키 순서에 추가
                        knowCnt[j]++; // j 는 자신보다 작은 i를 알고 있는 키 순서에 추가
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < N; i++) {
                if (knowCnt[i] == N - 1) {
                    res++;
                }
            }
            System.out.println("#" + tc + " " + res);

        }

    }
}
