package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_21938_영상처리_bfs {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] screen;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        double[][] tempScreen = new double[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tempScreen[i][j] = (r + g + b) / 3;
            }
        }

        int T = Integer.parseInt(in.readLine());
        screen = getNewScreen(tempScreen, T);

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (screen[i][j] == 255) {
                    bfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        screen[x][y] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (screen[nx][ny] == 255) {
                    q.offer(new int[]{nx, ny});
                    screen[nx][ny] = 0;
                }
            }
        }
    }

    private static int[][] getNewScreen(double[][] tempScreen, int t) {
        int[][] screen = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                screen[i][j] = tempScreen[i][j] >= (double) t ? 255 : 0;
            }
        }
        return screen;
    }
}