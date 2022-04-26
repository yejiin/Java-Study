package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {

    static int N;
    static int[][] map;
    static int result;

    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = -1;
            // (i, j) 하나씩 방문하면서 최대값 찾기
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    boolean[] eaten = new boolean[101];  // 이미 먹은 디저트인지 확인
                    dfs(i, j, i, j, 0, 0, eaten);
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int startX, int startY, int x, int y, int d, int visitCnt, boolean[] eaten) {

        if (d == 3 && startX == x && startY == y) {  // startX, startY에 도착하는 경우
            result = Math.max(result, visitCnt);
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (d + i == 4)
                break;

            int nx = x + dx[d + i];
            int ny = y + dy[d + i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {  // 지역 안에 있는 경우
                if (!eaten[map[nx][ny]]) {  // 안 먹었던 디저트 가게로만 이동
                    eaten[map[nx][ny]] = true;
                    dfs(startX, startY, nx, ny, d + i, visitCnt + 1, eaten);
                    eaten[map[nx][ny]] = false;
                }
            }
        }
    }
}
