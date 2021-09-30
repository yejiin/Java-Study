package solution.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {

    static int N, M;
    static int R, C;
    static int L;
    static int[][] map;
    static int cnt;

    // 상, 좌, 하, 우
    static int[][] dxy = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cnt = 0;
            bfs();

            System.out.println("#" + tc + " " + cnt);
        }
    }

    private static void bfs() {
        int time = 0; // 소요 시간
        Queue<int[]> q = new LinkedList<int[]>();

        q.offer(new int[] { R, C });

        while (!q.isEmpty()) {

            if (time == L)
                return;

            int size = q.size();
            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();

                if (map[cur[0]][cur[1]] == 0 || map[cur[0]][cur[1]] == -1)
                    continue;

                move(map[cur[0]][cur[1]], cur[0], cur[1], q);
            }
            time++;
        }

    }

    private static void move(int type, int x, int y, Queue<int[]> q) {
        map[x][y] = -1; // 지나간 곳은 -1로 표시
        cnt++;

        int[] dNum = getDirections(type); // type: 터널 구조물 타입, 터널 구조물로 이동할 수 있는 방향 리스트

        for (int d : dNum) {
            int nx = x + dxy[d][0];
            int ny = y + dxy[d][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;

            if (map[nx][ny] == 0 || map[nx][ny] == -1)
                continue;

            if (isAvaliable(d, map[nx][ny])) { // 현재 터널에서 다음 터널의 방향과 다음 터널의 구조물 타입과 연결 가능한지 확인
                q.offer(new int[] { x + dxy[d][0], y + dxy[d][1] });
            }
        }

    }

    private static boolean isAvaliable(int d, int type) {

        int[] dNum = getDirections(type); // 다음 터널 구조물로 이동할 수 있는 방향 리스트

        for (int i = 0; i < dNum.length; i++) {
            if (dNum[i] != d && dNum[i] % 2 == d % 2) // 상(0), 하(2) / 좌(1), 우(3) -> 다음 터널의 방향이 현재 방향과 같지 않고 현재 방향과 반대
                // 방향의 다음 터널 방향이 있으면 true
                return true;
        }

        return false;
    }

    private static int[] getDirections(int type) {

        switch (type) {
            case 1:
                return new int[] { 0, 1, 2, 3 };
            case 2:
                return new int[] { 0, 2 };
            case 3:
                return new int[] { 1, 3 };
            case 4:
                return new int[] { 0, 3 };
            case 5:
                return new int[] { 2, 3 };
            case 6:
                return new int[] { 1, 2 };
            case 7:
                return new int[] { 0, 1 };
        }
        return null;
    }
}
