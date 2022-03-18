package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 결과 : 획득한 점수의 합
public class Main_BOJ_23288_주사위굴리기2 {

    static int N, M, K;  // N: 지도 세로 크기, M: 지도 가로 크기, K: 이동 횟수(1~1000)
    static int[][] map;
    static int result;

    static int x, y, direction;
    static int[] dice;

    static int[][] diceMap = {
            {4, 2, 1, 6, 5, 3},  // 오른쪽으로 굴렀을 때
            {2, 6, 3, 4, 1, 5},  // 아래쪽으로 굴렀을 때
            {3, 2, 6, 1, 5, 4},  // 왼쪽으로 굴렀을 때
            {5, 1, 3, 4, 6, 2}   // 위쪽으로 굴렀을 때
    };

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 주사위 초기 위치
        x = 0;
        y = 0;
        direction = 0;  // 주사위 이동 방향 -- 0:오른쪽, 1:아래쪽, 2:왼쪽, 3:위쪽
        dice = new int[]{1, 2, 3, 4, 5, 6};  // 초기 주사위 모양
        for (int i = 0; i < K; i++) {
            move();
        }
        System.out.println(result);
    }

    private static void move() {
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        // 지도 넘어가는 경우 이동방향 바꾸기
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
            direction = (direction + 2) % 4;
            nx = x + dx[direction];
            ny = y + dy[direction];
        }

        int[] tempDice = new int[6];
        System.arraycopy(dice, 0, tempDice, 0, 6);

        // 주사위 굴리기
        for (int i = 0; i < 6; i++) {
            dice[i] = tempDice[diceMap[direction][i] - 1];
        }

        x = nx;
        y = ny;

        getScore(x, y, map[x][y]);
        changeDirection();
    }

    private static void getScore(int x, int y, int score) {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (visited[nx][ny])
                    continue;

                if (map[nx][ny] == score) {
                    cnt++;
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        result += (cnt + 1) * score;
    }

    private static void changeDirection() {
        if (dice[5] > map[x][y]) {  // 90도 시계 방향
            direction = (direction + 1) % 4;
        } else if (dice[5] < map[x][y]) {  // 반시계 방향
            direction = ((direction - 1) < 0 ? 3 : direction - 1) % 4;
        }
    }
}
