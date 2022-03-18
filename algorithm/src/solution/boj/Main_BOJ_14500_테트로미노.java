package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14500_테트로미노 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int result;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

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

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                calcExceptionBlock(i, j);
            }
        }
        System.out.println(result);
    }

    private static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            dfs(nx, ny, count + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    private static void calcExceptionBlock(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int sum = map[x][y];

            for (int j = 0; j < 3; j++) {
                int nx = x + dx[(i + j) % 4];
                int ny = y + dy[(i + j) % 4];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    break;

                sum += map[nx][ny];
            }
            result = Math.max(result, sum);
        }
    }
}
