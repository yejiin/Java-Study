package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int maxHouse = bfs(i, j, map, N, M); // 해당 위치의 홈방범 서비스에서 서비스 가능한 최대 집의 수
                    result = Math.max(result, maxHouse);
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y, int[][] map, int n, int m) {
        int[] homeCnt = new int[n * 2];  // 거리에 따라 존재하는 집의 개수

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();  // x, y, dis
        q.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        if (map[x][y] == 1) homeCnt[1]++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
                    continue;

                q.offer(new int[] {nx, ny, cur[2] + 1});
                visited[nx][ny] = true;

                if (map[nx][ny] == 1) homeCnt[cur[2] + 1]++;
            }
        }
        return findMaxHouse(homeCnt, n, m);
    }

    private static int findMaxHouse(int[] homeCnt, int n, int m) {
        int max = 0;

        int[] stacked = new int[n * 2];  // 거리에 따른 누적된 집의 수
        for (int k = 1; k < n * 2; k++) {  // K를 1씩 늘려가며 서비스 운영
            stacked[k] += stacked[k - 1] + homeCnt[k];

            int cost = k  * k + (k - 1) * (k - 1);
            if (stacked[k] * m >= cost) {
                max = Math.max(max, stacked[k]);
            }
        }
        return max;
    }
}
