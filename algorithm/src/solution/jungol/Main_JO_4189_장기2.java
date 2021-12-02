package solution.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_4189_장기2 {

    static int N, M;
    static int[][] map;
    static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine().trim());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int tx = Integer.parseInt(st.nextToken());
        int ty = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        BFS(sx, sy, tx, ty);

        System.out.print(result);
    }

    static void BFS(int sx, int sy, int tx, int ty) {
        boolean[][] visited = new boolean[N + 1][M + 1];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {sx, sy});
        visited[sx][sy] = true;

        int dist = 0;
        while(!q.isEmpty()) {

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {

                int[] cur = q.poll();

                for (int d = 0; d < 8; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx < 1 || nx > N || ny < 1 || ny > M)
                        continue;

                    if (!visited[nx][ny]) {

                        if (nx == tx && ny == ty) {
                            result = dist + 1;
                            return;
                        }

                        q.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;

                    }
                }
            }
            dist++;
        }
    }
}
