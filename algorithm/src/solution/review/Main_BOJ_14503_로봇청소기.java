package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기 {

    static int N, M;
    static int[][] map;
    static int[] vaccum;
    static int result;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        vaccum = new int[] {x, y, d};

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result++;
        map[x][y] = 2;
        while (true) {
            if (!clean(vaccum[0], vaccum[1], vaccum[2]))
                break;
        }

        System.out.println(result);
    }

    private static boolean clean(int x, int y, int d) {

        for (int i = 1; i <= 4; i++) {
            int nd = (d - i + 4) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];

            if (map[nx][ny] == 0) {
                result++;
                map[nx][ny] = 2;

                vaccum[0] = nx;
                vaccum[1] = ny;
                vaccum[2] = nd;

                return true;
            }
        }

        int nx = x + dx[(d + 2) % 4];
        int ny = y + dy[(d + 2) % 4];
        if (map[nx][ny] == 1)
            return false;

        vaccum[0] = nx;
        vaccum[1] = ny;
        return true;
    }
}
