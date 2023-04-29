package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DFS
 */
public class Main_BOJ_21772_가희의고구마먹방 {

    static int R, C, T;
    static char[][] map;
    static int result;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = in.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'G') {
                    dfs(i, j, 0, 0, map);
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs(int x, int y, int cnt, int sCnt, char[][] map) {
        if (cnt == T) {  // 백트래킹
            result = Math.max(result, sCnt);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#') {
                continue;
            }

            if (map[nx][ny] == 'S') {
                map[nx][ny] = '.';
                dfs(nx, ny, cnt + 1, sCnt + 1, map);
                map[nx][ny] = 'S';
            } else {
                dfs(nx, ny, cnt + 1, sCnt, map);
            }
        }
    }
}
