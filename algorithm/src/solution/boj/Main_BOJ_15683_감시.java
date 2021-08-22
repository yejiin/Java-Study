package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15683_감시 {

    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int[][] cctv;

    static int[] data;
    static int result = Integer.MAX_VALUE;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        cctv = new int[8][3];
        int cctvNum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int m = Integer.parseInt(st.nextToken());
                map[i][j] = m;

                if (m == 1) cctv[cctvNum++] = new int[] {1, i, j};
                else if (m == 2) cctv[cctvNum++] = new int[] {2, i, j};
                else if (m == 3) cctv[cctvNum++] = new int[] {3, i, j};
                else if (m == 4) cctv[cctvNum++] = new int[] {4, i, j};
                else if (m == 5) cctv[cctvNum++] = new int[] {5, i, j};
            }
        }

        data = new int[cctvNum];
        combination(0, cctvNum);
        System.out.println(result);
    }

    static void combination(int cnt, int num) {
        if (cnt == num) {
            copyMap = new int[N][M];
            for(int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }
            setDirection(num);
            getBlindSpotNum();
            return;
        }

        for (int i = 0; i < 4; i++) {
            data[cnt] = i;
            combination(cnt + 1, num);
        }
    }

    static void setDirection(int num) {
        for (int i = 0; i < num; i++) {
            if (cctv[i][0] == 1) {
                if (data[i] == 0) {
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                } else if (data[i] == 1) {
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                } else if (data[i] == 2) {
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                } else if (data[i] == 3) {
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                }
            } else if (cctv[i][0] == 2) {
                if (data[i] == 0) {
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                } else if (data[i] == 1) {
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                } else {
                    return;
                }
            } else if (cctv[i][0] == 3) {
                if (data[i] == 0) {
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                } else if (data[i] == 1) {
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                } else if (data[i] == 2) {
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                } else if (data[i] == 3) {
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                }
            } else if (cctv[i][0] == 4) {
                if (data[i] == 0) {
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                } else if (data[i] == 1) {
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                } else if (data[i] == 2) {
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                } else if (data[i] == 3) {
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                }
            } else if (cctv[i][0] == 5) {
                if (data[i] == 0) {
                    watch(cctv[i][1], cctv[i][2], 0);  // 상
                    watch(cctv[i][1], cctv[i][2], 1);  // 하
                    watch(cctv[i][1], cctv[i][2], 2);  // 좌
                    watch(cctv[i][1], cctv[i][2], 3);  // 우
                } else {
                    return;
                }
            }
        }
    }

    static void watch(int x, int y, int d) {  // cctv x좌표, y좌표, 방향
        while(true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                return;
            }

            if (copyMap[nx][ny] == 6)
                return;
            else if (copyMap[nx][ny] >= 1 && copyMap[nx][ny] <= 5) {
                x = nx;
                y = ny;
                continue;
            }
            else
                copyMap[nx][ny] = -1;
            x = nx;
            y = ny;
        }
    }

    static void getBlindSpotNum() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.min(result, count);
    }

}
