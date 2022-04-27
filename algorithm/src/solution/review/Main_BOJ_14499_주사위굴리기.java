package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 1. 처음에 주사위 모든 면은 0
 2. 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면의 수가 칸에 복사
 3. 아니면, 칸에 쓰여 있는 수가 주사위의 바닥면에 복사

 바닥면 index = 5

 */
public class Main_BOJ_14499_주사위굴리기 {

    static int N, M, K;
    static int[] loc;
    static int[][] map;

    static int[] dice;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] diceDir = {
            {3, 1, 0, 5, 4, 2},
            {2, 1, 5, 0, 4, 3},
            {4, 0, 2, 3, 5, 1},
            {1, 5, 2, 3, 0, 4}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        loc = new int[] {x, y};
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[6];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            if (move(dir))
                System.out.println(dice[0]);
        }

    }

    private static boolean move(int d) {

        int nx = loc[0] + dx[d];
        int ny = loc[1] + dy[d];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
            return false;

        loc[0] = nx;
        loc[1] = ny;

        dice = moveDice(d);

        if (map[nx][ny] == 0)
            map[nx][ny] = dice[5];
        else {
            dice[5] = map[nx][ny];
            map[nx][ny] = 0;
        }

        return true;
    }

    private static int[] moveDice(int d) {

        int[] tempDice = new int[6];
        for (int i = 0; i < 6; i++) {
            tempDice[i] = dice[diceDir[d][i]];
        }
        return tempDice;
    }
}
