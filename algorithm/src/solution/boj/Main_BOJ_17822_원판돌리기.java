package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17822_원판돌리기 {
    
    static int N, M, T;
    static int[][] board;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // x배수 원판 회전
            int num = x;
            for (int i = 1; i <= N / x; i++) {
                rotate(num * i - 1, d, k);
            }

            // 같은 수의 인접한 칸이 있는지 확인
            boolean flag = false;
            int[][] adjacent = new int[N][M];  // 0: 미방문, 1: 방문, 2: 인접
            int sum = 0, cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != 0 && adjacent[i][j] == 0) {
                        if (find(i, j, adjacent))
                            flag = true;
                    }

                    if (board[i][j] != 0) {
                        sum += board[i][j];
                        cnt++;
                    }
                }
            }

            if (flag)   // 인접한 칸에 같은 수가 있는 경우 모두 지움
                remove(adjacent);
            else
                calc((double) sum / cnt);
        }
        System.out.println(getSum());
    }

    private static void rotate(int num, int d, int k) {

        int[] temp = new int[M];
        System.arraycopy(board[num], 0, temp, 0, M);

        if (d == 0) {  // 시계 방향 회전
            for (int i = M - 1; i >= 0; i--) {
                board[num][i] = temp[(M + i - k) % M];
            }
        } else if (d == 1) {  // 반시계 방향 회전
            for (int i = 0; i < M; i++) {
                board[num][i] = temp[(i + k) % M];
            }
        }
    }

    private static boolean find(int x, int y, int[][] adjacent) {
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        int xy = adjacent[x][y];
        adjacent[x][y] = 2;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = (M + cur[1] + dy[d]) % M;

                if (nx < 0 || nx >= N || adjacent[nx][ny] > 0)
                    continue;

                // 인접하고 수가 같은 경우
                if (board[nx][ny] == board[x][y]) {
                    adjacent[nx][ny] = 2;
                    flag = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if (!flag && xy != 2)
            adjacent[x][y] = 1;

        return flag;
    }

    private static void remove(int[][] adjacent) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (adjacent[i][j] == 2)
                    board[i][j] = 0;
            }
        }
    }

    private static void calc(double avg) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j] > avg)
                        board[i][j] -= 1;
                    else if (board[i][j] < avg)
                        board[i][j] += 1;
                }
            }
        }
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }
}