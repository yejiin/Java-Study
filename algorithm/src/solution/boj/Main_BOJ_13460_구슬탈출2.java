package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 출력: 빨간 구슬을 빼내는 최소 횟수
public class Main_BOJ_13460_구슬탈출2 {

    static int N, M;
    static char[][] board;
    static int[] red;
    static int[] blue;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        red = new int[2];
        blue = new int[2];

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                } else if (board[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }
        System.out.println(bfs(red, blue));
    }

    private static int bfs(int[] red, int[] blue) {
        boolean[][][][] visited = new boolean[N][M][N][M];  // [빨간 구슬, 파란구슬] 방문여부 확인
        Queue<Bead> q = new LinkedList<>();

        q.offer(new Bead(red[0], red[1], blue[0], blue[1], 1));
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while (!q.isEmpty()) {
            Bead cur = q.poll();

            if (cur.cnt > 10)
                return -1;

            for (int d = 0; d < 4; d++) {  // 상, 하, 좌, 우로 기울여보기
                int nRX = cur.redX;
                int nRY = cur.redY;
                int nBX = cur.blueX;
                int nBY = cur.blueY;

                boolean isRedHole = false;
                boolean isBlueHole = false;
                // 빨간색 구슬 이동
                while (board[nRX + dx[d]][nRY + dy[d]] != '#') {
                    nRX += dx[d];
                    nRY += dy[d];

                    if (board[nRX][nRY] == 'O')
                        isRedHole = true;
                }

                // 파란색 구슬 이동
                while (board[nBX + dx[d]][nBY + dy[d]] != '#') {
                    nBX += dx[d];
                    nBY += dy[d];

                    if (board[nBX][nBY] == 'O')
                        isBlueHole = true;
                }

                if (isBlueHole)
                    continue;

                if (isRedHole && !isBlueHole)
                    return cur.cnt;

                if (nRX == nBX && nRY == nBY)  {  // 같은 위치에 있다면
                    if(d == 0) {  // 위로 기울인 경우
                        if (cur.redX > cur.blueX)
                            nRX++;
                        else
                            nBX++;
                    } else if (d == 1) {  // 아래로 기울인 경우
                        if (cur.redX > cur.blueX)
                            nBX--;
                        else
                            nRX--;
                    } else if (d == 2) {  // 왼쪽으로 기울인 경우
                        if (cur.redY > cur.blueY)
                            nRY++;
                        else
                            nBY++;
                    } else {  // 오른쪽으로 기울인 경우
                        if (cur.redY > cur.blueY)
                            nBY--;
                        else
                            nRY--;
                    }
                }

                if (!visited[nRX][nRY][nBX][nBY]) {
                    q.offer(new Bead(nRX, nRY, nBX, nBY, cur.cnt + 1));
                    visited[nRX][nRY][nBX][nBY] = true;
                }
            }
        }
        return -1;
    }

    static class Bead {
        int redX, redY;
        int blueX, blueY;
        int cnt;

        public Bead(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }
}
