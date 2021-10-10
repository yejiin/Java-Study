package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_4485_녹색옷입은애가젤다지 {

    static int N;
    static int[][] map;
    static int[][] minTime;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 1;
        while (true) {

            N = Integer.parseInt(in.readLine());

            if (N == 0)
                break;

            map = new int[N][N];
            minTime = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    minTime[i][j] = INF;
                }
            }

            System.out.println("Problem " + tc++ + ": " + dijkstra(0, 0));

        }
    }

    private static int dijkstra(int startX, int startY) {

        boolean[][] visited = new boolean[N][N];

        PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        minTime[startX][startY] = map[startX][startY];
        pQueue.offer(new int[] {startX, startY, minTime[startX][startY]});

        while (true) {
            int[] cur = pQueue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int minCost = cur[2];

            if (visited[curX][curY])
                continue;

            visited[curX][curY] = true;

            if (curX == N - 1 && curY == N - 1)
                return minCost;

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && minTime[nx][ny] > minCost + map[nx][ny]) {
                    minTime[nx][ny] = minCost + map[nx][ny];
                    pQueue.offer(new int[] {nx, ny, minTime[nx][ny]});
                }
            }
        }
    }
}
