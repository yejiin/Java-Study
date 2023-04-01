package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 빈 칸을 기준으로 BFS
 */
public class Main_BOJ_17086_아기상어2 {

    private static int N, M;
    private static int[][] map, safetyDistance;

    private static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        safetyDistance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(safetyDistance[i], Integer.MAX_VALUE);
        }

        // bfs 안전 거리 셋팅
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (safetyDistance[i][j] != Integer.MAX_VALUE) {
                    result = Math.max(safetyDistance[i][j], result);
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 8; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
                    continue;

                if (map[nx][ny] == 1 && safetyDistance[x][y] > cur.distance + 1) {
                    safetyDistance[x][y] = cur.distance + 1;
                }

                q.offer(new Node(nx, ny, cur.distance + 1));
                visited[nx][ny] = true;
            }
        }
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
