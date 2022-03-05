package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14499_주사위굴리기 {

    // N, M : 지도의 세로 가로
    // x, y : 주사위의 처음 좌표
    // K : 명령의 개수
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice;

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    static int[][] diceDirNumbers = {
            {1, 2, 3, 4, 5, 6},  // 윗면, 북쪽면, 동쪽면, 서쪽면, 남쪽면, 아랫면
            {4, 2, 1, 6, 5, 3},  // 동쪽으로 옮겼을 때
            {3, 2, 6, 1, 5, 4},  // 서쪽으로 옮겼을 때
            {5, 1, 3, 4, 6, 2},  // 북쪽으로 옮겼을 때
            {2, 6, 3, 4, 1, 5}}; // 남쪽으로 옮겼을 때

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[]{0, 0, 0, 0, 0, 0, 0};
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < K; i++) {
            move(Integer.parseInt(st.nextToken()));
        }
    }

    private static void move(int d) {

        // 지도 이동
        int nx = x + dx[d];
        int ny = y + dy[d];

        // 바깥으로 이동시키려고 하는 경우
        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
            return;

        x = nx;
        y = ny;

        // 주사위 이동
        dice = moveDice(d);

        if (map[nx][ny] == 0) {  // 지도의 칸이 0인 경우
            map[nx][ny] = dice[6];
        } else {  // 지도의 칸이 0이 아닌경우
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }
        System.out.println(dice[1]);
    }

    private static int[] moveDice(int d) {
        int[] numbers = diceDirNumbers[d];

        int[] diceTemp = new int[7];
        for (int i = 0; i < 6; i++) {
            diceTemp[i + 1] = dice[numbers[i]];
        }
        return diceTemp;
    }
}
