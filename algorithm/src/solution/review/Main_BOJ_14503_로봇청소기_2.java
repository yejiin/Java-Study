package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기_2 {

    static int N, M;

    static int[][] map;
    static int cleanedCnt;

    static int[] dx = {-1, 0, 1, 0};  // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] cleaner = new int[3];  // 로봇 청소기 {x, y, 방향}
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 3; i++) {
            cleaner[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(cleaner);

        System.out.println(cleanedCnt);
    }

    private static void move(int[] cleaner) {

        map[cleaner[0]][cleaner[1]] = 2;
        cleanedCnt++;

        while(true) {
            int i;
            for (i = 1; i <= 4; i++) {
                int nd = (cleaner[2] - i + 4) % 4;
                int nx = cleaner[0] + dx[nd];
                int ny = cleaner[1] + dy[nd];

                if (map[nx][ny] == 0) {  // 1
                    map[nx][ny] = 2;
                    cleanedCnt++;

                    cleaner[0] = nx;
                    cleaner[1] = ny;
                    cleaner[2] = nd;
                    break;
                }
            }

            if (i == 5) {  // 3
                cleaner[0] += dx[(cleaner[2] + 2) % 4];
                cleaner[1] += dy[(cleaner[2] + 2) % 4];

                if (map[cleaner[0]][cleaner[1]] == 1) {  // 4
                    break;
                }
            }
        }
    }
}
