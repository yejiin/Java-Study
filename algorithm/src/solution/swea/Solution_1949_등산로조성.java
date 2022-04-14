package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {

    static int maxDistance = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<int[]> highestLoc = new ArrayList<>();   // 가장 높은 지점 저장
            int highest = 0;

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (highest < map[i][j]) {  // 측정하려는 봉우리 높이가 이전까지 높이보다 큰 경우
                        highestLoc.clear();
                        highest = map[i][j];
                        highestLoc.add(new int[]{i, j});
                    } else if (highest == map[i][j]) {  // 높이가 같은 경우
                        highestLoc.add(new int[]{i, j});
                    }
                }
            }

            maxDistance = 0;
            for (int i = 0, size = highestLoc.size(); i < size; i++) {
                int[] location = highestLoc.get(i);

                boolean[][] visited = new boolean[N][N];
                visited[location[0]][location[1]] = true;
                dfs(1, location[0], location[1], highest, false, visited, N, K, map);
            }
            sb.append("#").append(tc).append(" ").append(maxDistance).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int distance, int x, int y, int height, boolean construction, boolean[][] visited, int N, int K, int[][] map) {

        if (maxDistance < distance) maxDistance = distance;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
                continue;

            if (map[nx][ny] < height) {  // 현재 높이가 이전 높이보다 작은 경우
                visited[nx][ny] = true;
                dfs(distance + 1, nx, ny, map[nx][ny], construction, visited, N, K, map);
                visited[nx][ny] = false;
            } else {
                // 공사를 한 적이 없고, 이전 높이에서 최대 K만큼 빼서 경사로를 만들 수 있는지 확인
                if (!construction && height > map[nx][ny] - K) {
                    visited[nx][ny] = true;
                    dfs(distance + 1, nx, ny, height - 1, true, visited, N, K, map);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
