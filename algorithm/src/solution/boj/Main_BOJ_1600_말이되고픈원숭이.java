package solution.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class Main_BOJ_1600_말이되고픈원숭이 {

    static int K, W, H;
    static int[][] map;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int[] ddx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] ddy = { -1, -2, -2, -1, 1, 2, 2, 1 };

    static class Monkey {
        int x, y, count, k;

        public Monkey(int x, int y, int count, int k) {
            super();
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(in.readLine());

        st = new StringTokenizer(in.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move(0, 0));

    }

    // bfs
    private static int move(int x, int y) {

        Queue<Monkey> q = new LinkedList<>();
        boolean[][][] visited = new boolean[H][W][K + 1]; // x, y 좌표 + k 선택 횟수에 대한 방분여부

        q.offer(new Monkey(x, y, 0, 0));
        visited[x][y][0] = true;

        while (!q.isEmpty()) {
            Monkey cur = q.poll();

            if (cur.x == H - 1 && cur.y == W - 1) // 가장 먼저 큐에서 나온 도착점의 count가 가장 작음
                return cur.count;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W)
                    continue;

                if (map[nx][ny] == 0 && !visited[nx][ny][cur.k]) {
                    q.offer(new Monkey(nx, ny, cur.count + 1, cur.k));
                    visited[nx][ny][cur.k] = true;
                }
            }

            if (cur.k == K) // 원숭이가 말의 움직임을 k번 모두 사용했다면
                continue;

            for (int d = 0; d < 8; d++) {
                int nx = cur.x + ddx[d];
                int ny = cur.y + ddy[d];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W)
                    continue;

                if (map[nx][ny] == 0 && !visited[nx][ny][cur.k + 1]) {
                    q.offer(new Monkey(nx, ny, cur.count + 1, cur.k + 1));
                    visited[nx][ny][cur.k + 1] = true;
                }
            }
        }

        return -1; // 도착점까지 도달 못하면
    }
}