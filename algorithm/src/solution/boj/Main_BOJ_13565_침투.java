package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_13565_침투 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};

    static int M, N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) == '0' ? 0 : 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (board[0][i] == 0 && bfs(0, i)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static boolean bfs(int x, int y) {
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || ny >= N) {
                    continue;
                }

                if (nx == M) {
                    return true;
                } else {
                    if (visited[nx][ny] || board[nx][ny] == 1) {
                        continue;
                    }
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
}
