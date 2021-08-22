package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {

    static int N;

    static int[] office;
    static int[] home;
    static int[][] client;

    static boolean[] isSelected;
    static int[] visitClient;
    static int result;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine(), " ");

            office = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            home = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            client = new int[N][2];
            isSelected = new boolean[N];
            visitClient = new int[N];
            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                client[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            }

            permutation(0, 0, office[0], office[1]);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    // 백트래킹
    private static void permutation(int cnt, int distance, int startX, int startY) {
        if (distance > result || cnt == N) {
//            distance();
            distance += Math.abs(home[0] - startX) + Math.abs( home[1] - startY);
            result = Math.min(result, distance);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i])
                continue;;

            int d =  Math.abs(startX - client[i][0]) + Math.abs(startY - client[i][1]);

            visitClient[cnt] = i;
            isSelected[i] = true;
            distance += d;
            permutation(cnt + 1, distance, client[i][0], client[i][1]);
            isSelected[i] = false;
            distance -= d;
        }
    }

    // 완전탐색
    private static void distance() {
        int dis = Math.abs(office[0] - client[visitClient[0]][0]) + Math.abs(office[1] - client[visitClient[0]][1]);

        for (int i = 0;i < N - 1; i++) {
            dis += Math.abs(client[visitClient[i]][0] - client[visitClient[i + 1]][0]) + Math.abs(client[visitClient[i]][1] - client[visitClient[i + 1]][1]);
            if (dis > result)
                return;
        }
        dis += Math.abs(home[0] - client[visitClient[N - 1]][0]) + Math.abs(home[1] - client[visitClient[N - 1]][1]);

        result = Math.min(result, dis);
    }
}
