package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집 {

    static int R, C;
    static char[][] graph;
    static int result;

    static int[] d = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = in.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        for (int k = 0; k < R; k++) {
            dfs(k, 0);
        }

        System.out.println(result);
    }

    public static boolean dfs(int r, int c) {

        for (int k = 0; k < 3; k++) {
            int nr = r + d[k];
            int nc = c + 1;

            if (nr >= 0 && nr < R && graph[nr][nc] == '.') {
                if (nc == C - 1) {
                    result++;
                    return true;
                }
                graph[nr][nc] = 'x';
                if(dfs(nr, nc))
                    return true;
            }
        }
        return false;
    }
}
