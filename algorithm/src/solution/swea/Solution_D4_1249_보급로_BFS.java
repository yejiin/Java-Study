package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1249_보급로_BFS {

    static int N;
    static int[][] map, minTime;
    static boolean[][] visited;
    static int result;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());

            map = new int[N][N];
            minTime = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(minTime[i], Integer.MAX_VALUE);
            }
            minTime[0][0] = 0;

            visited = new boolean[N][N];
            result = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                String s = in.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            bfs(0, 0);
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];

            if (curx == N - 1 && cury == N - 1) { // 도착지에 도착했을 때 이전에 도착한 시간보다 작으면 갱신
                if (result > minTime[N - 1][N - 1])
                    result = minTime[N - 1][N - 1];
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (!visited[nx][ny] || minTime[nx][ny] > minTime[curx][cury] + map[nx][ny]) {
                    visited[nx][ny] = true;
                    minTime[nx][ny] = minTime[curx][cury] + map[nx][ny];
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }
}

