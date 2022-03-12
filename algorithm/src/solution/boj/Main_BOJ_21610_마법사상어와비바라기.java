package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

// 출력 : 바구니에 들어있는 물의 양의 합
public class Main_BOJ_21610_마법사상어와비바라기 {

    static int N, M;  // N : 바구니 크기, M : 이동 개수
    static int[][] basket;

    static ArrayList<Cloud> clouds;
    static ArrayList<Cloud> movedClouds;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        basket = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                basket[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds = new ArrayList<>();
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));

        movedClouds = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            move(d, s);

            magic();

            makeCloud();
        }
        System.out.println(countWater());
    }

    private static void move(int d, int s) {
        movedClouds.clear();

        // 구름 이동
        for (Cloud cloud : clouds) {
            int nx = 0;
            if (dx[d] < 0)
                nx = (cloud.x + s * (N + dx[d])) % N;
            else
                nx = (cloud.x + (s * dx[d])) % N;

            int ny = 0;
            if (dy[d] < 0)
                ny = (cloud.y + s * (N + dy[d])) % N;
            else
                ny = (cloud.y + (s * dy[d])) % N;

            // 물의 양 1 증가
            basket[nx][ny]++;
            movedClouds.add(new Cloud(nx, ny));
        }
    }

    private static void magic() {

        for (Cloud movedCloud : movedClouds) {
            int cnt = 0;  // 대각선 방향으로 물이 있는 바구니 수

            // 방향 1, 3, 5, 7 => (i * 2) + 1
            for (int i = 0; i < 4; i++) {
                int nx = movedCloud.x + dx[i * 2 + 1];
                int ny = movedCloud.y + dy[i * 2 + 1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (basket[nx][ny] != 0)
                    cnt++;
            }
            basket[movedCloud.x][movedCloud.y] += cnt;
        }
    }


    private static void makeCloud() {

        ArrayList<Cloud> newClouds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!movedClouds.contains(new Cloud(i, j))) {
                    if (basket[i][j] >= 2) {
                        newClouds.add(new Cloud(i, j));
                        basket[i][j] -= 2;
                    }
                }
            }
        }
        clouds = newClouds;
    }

    private static int countWater() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += basket[i][j];
            }
        }
        return sum;
    }

    static class Cloud {
        int x, y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cloud cloud = (Cloud) o;
            return x == cloud.x && y == cloud.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
