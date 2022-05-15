package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17070_파이프옮기기1 {

    static int N;
    static int[][] map;

    static int result;

    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(result);
    }

    private static void dfs(int x, int y, int d) {

        if (x >= N || y >= N)  // 범위 벗어나는 경우
            return;

        if (map[x][y] == 1)  // 이동하려는 곳이 벽인 경우
            return;

        if (d == 2 && (map[x - 1][y] == 1 || map[x][y - 1] == 1))  // 대각선으로 이동할 때, 주변이 벽인 경우
            return;

        if (x == N - 1 && y == N - 1) {
            result++;
            return;
        }

        if (d < 2) {
            dfs(x + dx[d], y + dy[d], d);  // d 방향으로 이동
            dfs(x + dx[2], y + dy[2], 2);  // 대각선 방향으로 이동
        } else if (d == 2) {
            for (int i = 0; i < 3; i++) {  // 3 방향 모두 이동
                dfs(x + dx[i], y + dy[i], i);
            }
        }
    }
}
