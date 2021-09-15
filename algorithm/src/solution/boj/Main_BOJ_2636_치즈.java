package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2636_치즈 {

    static int N, M;
    static int[][] map;
    static int time; // 치즈가 모두 녹는데 걸리는 시간
    static ArrayList<Integer> cheeseCnt; // 시간마다 녹는 치즈 개수

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheeseCnt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setOutsideAir(0, 0);

        while (true) {
            int cnt = removeCheese();

            if (cnt == 0) {
                break;
            } else {
                cheeseCnt.add(cnt);
                time++;
            }
        }

        System.out.println(time);
        if (time != 0) {
            System.out.println(cheeseCnt.get(time - 1));
        } else { // 녹을 치즈가 없는 경우
            System.out.println(0);
        }
    }

    // 치즈 외부 공기와 치즈 구멍 속 공기 구분. 외부 공기는 3으로 설정. bfs 탐색.
    public static void setOutsideAir(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] { x, y });
        visited[x][y] = true;
        map[x][y] = 3;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    map[nx][ny] = 3;
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }

            }

        }

    }

    // 외부 공기에 노출된 녹은 치즈 제거
    private static int removeCheese() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1
                        && (map[i - 1][j] == 3 || map[i][j - 1] == 3 || map[i + 1][j] == 3 || map[i][j + 1] == 3)) {
                    boolean[][] visited = new boolean[N][M];
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                    map[i][j] = 2; // 녹을 치즈를 2로 설정

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cx = cur[0];
                        int cy = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dx[d];
                            int ny = cy + dy[d];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                                continue;

                            if (visited[nx][ny])
                                continue;

                            if (map[nx][ny] == 1 && (map[nx - 1][ny] == 3 || map[nx + 1][ny] == 3
                                    || map[nx][ny - 1] == 3 || map[nx][ny + 1] == 3)) {

                                map[nx][ny] = 2;
                                visited[nx][ny] = true;
                                q.offer(new int[] { nx, ny });

                            }
                        }
                    }
                }
            }
        }

        int count = 0; // 남아 있는 치즈 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2 || map[i][j] == 1) {
                    count++;
                    if (map[i][j] == 2) // 녹은 치즈를 외부 공기로 설정
                        map[i][j] = 3;
                }
            }
        }

        // 외부 공기 다시 설정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0
                        && (map[i - 1][j] == 3 || map[i][j - 1] == 3 || map[i + 1][j] == 3 || map[i][j + 1] == 3)) {
                    setOutsideAir(i, j);
                }

            }
        }
        return count;
    }

}
