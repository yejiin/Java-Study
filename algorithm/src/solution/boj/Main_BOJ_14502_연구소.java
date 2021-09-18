package solution.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// dfs, bfs
public class Main_BOJ_14502_연구소 {

    static int N, M;
    static int[][] map;
    static ArrayList<int[]> virusList;
    static int count;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    virusList.add(new int[] { i, j });
                }
                map[i][j] = num;
            }
        }

        makeWall(0);
        System.out.println(count);

    }

    // dfs
    private static void makeWall(int count) {

        if (count == 3) {
            int[][] copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }

            moveVirus(copyMap);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 3; // 울타리 치기
                    makeWall(count + 1);
                    map[i][j] = 0;

                }
            }
        }

    }

    // bfs
    private static void moveVirus(int[][] copyMap) {

        Queue<int[]> q = new LinkedList<int[]>();

        for (int[] virus : virusList) {
            q.add(new int[] { virus[0], virus[1] });
            copyMap[virus[0]][virus[1]] = 2;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    q.offer(new int[] { nx, ny });
                }
            }

        }
        count = Math.max(count, countSafeZone(copyMap));
    }

    private static int countSafeZone(int[][] copyMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

}
