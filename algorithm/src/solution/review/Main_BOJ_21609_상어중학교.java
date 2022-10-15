package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 풀이 : https://www.youtube.com/watch?v=-w0NpzBsJps
public class Main_BOJ_21609_상어중학교 {

    static int N, M;
    static int[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = solve();
        System.out.println(ret);
    }

    private static int solve() {
        int point = 0;
        int curPoint = 0;

        do {
            curPoint = calcPoint();
            point += curPoint;
            down();
            rotate();
            down();
        } while (curPoint != 0);

        return point;
    }

    private static int calcPoint() {
        int point = 0;
        List<Integer> maxArea = new ArrayList<>();
        int maxRainbow = 0;

        for (int color = 1; color <= M; color++) {
            boolean[][] visited = new boolean[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && board[x][y] == color) {
                        Queue<Integer> q = new LinkedList<>();
                        List<Integer> area = new ArrayList<>();
                        int rainbow = 0;

                        q.offer(x * 100 + y);
                        area.add(x * 100 + y);
                        visited[x][y] = true;

                        while (!q.isEmpty()) {
                            int cur = q.poll();
                            int cx = cur / 100;
                            int cy = cur % 100;

                            for (int d = 0; d < 4; d++) {
                                int nx = cx + dx[d];
                                int ny = cy + dy[d];

                                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                    continue;
                                }

                                if (!visited[nx][ny] && (board[nx][ny] == color || board[nx][ny] == 0)) {
                                    q.offer(nx * 100 + ny);
                                    area.add(nx * 100 + ny);
                                    visited[nx][ny] = true;

                                    if (board[nx][ny] == 0) {
                                        rainbow++;
                                    }
                                }
                            }
                        }

                        if (maxArea.size() < area.size() || (maxArea.size() == area.size() && maxRainbow < rainbow)
                            || (maxArea.size() == area.size() && maxRainbow == rainbow && maxArea.get(0) < area.get(0))) {
                            maxArea = new ArrayList<>(area);
                            maxRainbow = rainbow;
                        }
                    }
                }
            }
        }

        if (maxArea.size() >= 2) {
            point = maxArea.size() * maxArea.size();
            for (int i = 0; i < maxArea.size(); i++) {
                int x = maxArea.get(i) / 100;
                int y = maxArea.get(i) % 100;
                board[x][y] = -2;
            }
        }

        return point;
    }

    private static void down() {
        for (int y = 0; y < N; y++) {
            int blank = 0;
            for (int x = N - 1; x >= 0; x--) {
                if (board[x][y] == -2) {
                    blank++;
                } else if (board[x][y] == -1) {
                    blank = 0;
                } else {
                    if (blank != 0) {
                        board[x + blank][y] = board[x][y];
                        board[x][y] = -2;
                    }
                }
            }
        }
    }

    private static void rotate() {
        int[][] temp = new int[N][N];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                temp[N - 1 - x][y] = board[y][x];
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                board[x][y] = temp[x][y];
            }
        }
    }
}
