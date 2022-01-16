package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16948_데스나이트 {

    static int N;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc= {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(r1, c1, r2, c2));
    }

    private static int bfs(int r1, int c1, int r2, int c2) {
        boolean[][] visited = new boolean[N][N];

        Queue<ChessPiece> q = new LinkedList<>();
        q.offer(new ChessPiece(r1, c1, 0));
        visited[r1][c1] = true;

        while(!q.isEmpty()) {
            ChessPiece cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                    continue;

                if (visited[nr][nc])
                    continue;

                if (nr == r2 && nc == c2)
                    return cur.cnt + 1;

                q.offer(new ChessPiece(nr, nc, cur.cnt + 1));
                visited[nr][nc] = true;
            }
        }
        return -1;
    }

    static class ChessPiece {
        int r, c, cnt;

        public ChessPiece(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
