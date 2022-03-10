package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 출력 : 남아있는 얼음 A[r][c]의 합
//       남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
public class Main_BOJ_20058_마법사상어와파이어스톰 {

    static int N, Q;
    static int boardLen;
    static int[][] board;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // board 한 변의 길이 2^N
        boardLen = (int) Math.pow(2, N);

        board = new int[boardLen][boardLen];

        for (int i = 0; i < boardLen; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < boardLen; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            // 격자 나누기, 회전
            divide(0, 0, boardLen, (int) Math.pow(2, L));
            // 얼음 양 줄이기
            decrease();
        }

        // 남아있는 얼음 합
        System.out.println(countIce());

        // 가장 큰 덩어리 칸의 개수
        boolean[][] visited = new boolean[boardLen][boardLen];
        int maxCnt = 0;
        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                if (board[i][j] != 0 && !visited[i][j]) {

                    int cnt = bfs(i, j, visited);
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }
        System.out.println(maxCnt);
    }

    // 2^len * 2^len 격자 나누기
    private static void divide(int r, int c, int size, int len) {

        if (size == len) {
            rotate(r, c, size);
        }

        if (size != len) {
            int half = size / 2;
            divide(r, c, half, len);
            divide(r, c + half, half, len);
            divide(r + half, c, half, len);
            divide(r + half, c + half, half, len);
        }
    }

    // 격자부분 시계 방향으로 90도 회전
    private static void rotate(int r, int c, int size) {
        int[][] temp = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp[i][j] = board[r + size - j - 1][c + i];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[r + i][c + j] = temp[i][j];
            }
        }
    }

    // 3개 이상 인접한 칸에 얼음없으면 양 1 줄어들기
    private static void decrease() {
        ArrayList<int[]> spaceList = new ArrayList<>();

        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                int cnt = 0;  // 얼음있는 인접한 칸 개수
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= boardLen || ny < 0 || ny >= boardLen)
                        continue;

                    if (board[nx][ny] != 0)
                        cnt++;
                }

                if (cnt < 3) {
                    if (board[i][j] != 0)
                        spaceList.add(new int[]{i, j});
                }
            }
        }

        for (int[] space : spaceList) {
            board[space[0]][space[1]] -= 1;
        }
    }

    private static int countIce() {
        int sum = 0;

        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;
        cnt++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= boardLen || ny < 0 || ny >= boardLen)
                    continue;
                if (visited[nx][ny])
                    continue;

                if (board[nx][ny] != 0) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
