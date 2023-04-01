package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14620_꽃길 {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        dfs(0,0);

        System.out.println(result);
    }

    private static void dfs(int count, int sum) {
        if (count == 3) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (!visited[i][j] && checkNearArea(i, j)) {
                    visited[i][j] = true;
                    visitedNear(i, j, true);                  // 값 세팅

                    dfs(count + 1, sum + nearSum(i, j));  // 재귀

                    visitedNear(i, j, false);                 // 값 초기화
                    visited[i][j] = false;
                }
            }
        }
    }

    private static void visitedNear(int x, int y, boolean isVisited) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            visited[nx][ny] = isVisited;
        }
    }

    private static boolean checkNearArea(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (visited[nx][ny])
                return false;
        }
        return true;
    }

    private static int nearSum(int x, int y) {
        int sum = map[x][y];
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            sum += map[nx][ny];
        }
        return sum;
    }
}
