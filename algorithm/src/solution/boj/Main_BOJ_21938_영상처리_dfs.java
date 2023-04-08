package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_21938_영상처리_dfs {

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
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return;
        }

        if (screen[x][y] == 255) {
            screen[x][y] = 0;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
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