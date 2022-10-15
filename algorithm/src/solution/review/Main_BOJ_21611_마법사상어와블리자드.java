package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 풀이 : https://www.youtube.com/watch?v=M-BIioqCUVk
public class Main_BOJ_21611_마법사상어와블리자드 {

    static int N, M;
    static int[][] map;
    static int[] line;
    static int lineSize;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        line = new int[N * N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            destroy(d - 1, s);
            convertToLine();
            while (destroyInLine() != 0) {
                removeZero();
            }
            removeZero();
            explode();
            convertToMat();
        }

        System.out.println(result);
    }

    private static void destroy(int d, int s) {
        int cx = N / 2;
        int cy = N / 2;

        for (int i = 1; i <= s; i++) {
            int nx = cx + (dx[d] * i);
            int ny = cy + (dy[d] * i);
            map[nx][ny] = 0;
        }
    }

    private static void convertToLine() {
        int[] ddx = {0, 1, 0, -1};
        int[] ddy = {-1, 0, 1, 0};

        lineSize = 0;
        int cx = N / 2;
        int cy = N / 2;
        int d = 0;
        int loopCount = 2;

        for (int dist = 1; dist < N; dist++) {
            if (dist == N - 1) {
                loopCount = 3;
            }

            for (int i = 0; i < loopCount; i++) {
                for (int j = 0; j < dist; j++) {
                    cx += ddx[d];
                    cy += ddy[d];

                    if(map[cx][cy] != 0) {
                        line[lineSize++] = map[cx][cy];
                    }
                }
                d = (d + 1) % 4;
            }
        }
    }

    private static int destroyInLine() {
        int point = 0;
        int count = 1;

        for (int i = 1; i < lineSize; i++) {
            if (line[i - 1] == line[i]) {
                count++;
            } else {
                if (count >= 4) {
                    for (int j = 1; j <= count; j++) {
                        point += line[i - j];
                        line[i - j] = 0;
                    }
                }
                count = 1;
            }
        }

        if (count >= 4) {
            for (int j = 1; j <= count; j++) {
                point += line[lineSize - j];
                line[lineSize - j] = 0;
            }
        }
        result += point;
        return point;
    }

    private static void removeZero() {
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < lineSize; i++) {
            if (line[i] != 0) {
                temp.add(line[i]);
            }
        }

        lineSize = temp.size();
        line = new int[lineSize];
        for (int i = 0; i < lineSize; i++) {
            line[i] = temp.get(i);
        }
    }

    private static void explode() {
        int tempSize = 0;
        int[] temp = new int[N * N];

        int count = 1;
        for (int i = 1; i < lineSize; i++) {
            if (line[i - 1] == line[i]) {
                count++;
            } else {
                if (tempSize < N * N - 2) {
                    temp[tempSize++] = count;
                    temp[tempSize++] = line[i - 1];
                }
                count = 1;
            }
        }

        if (lineSize > 0 && tempSize < N * N - 2){
            temp[tempSize++] = count;
            temp[tempSize++] = line[lineSize - 1];
        }

        line = new int[tempSize];
        lineSize = tempSize;
        for (int i = 0; i < lineSize; i++) {
            line[i] = temp[i];
        }
    }

    private static void convertToMat() {
        int[] ddx = {0, 1, 0, -1};
        int[] ddy = {-1, 0, 1, 0};

        int cx = N / 2;
        int cy = N / 2;
        int d = 0;
        int loopCount = 2;
        int cur = 0;

        for (int dist = 1; dist < N; dist++) {
            if (dist == N - 1) {
                loopCount = 3;
            }

            for (int i = 0; i < loopCount; i++) {
                for (int j = 0; j < dist; j++) {
                    cx += ddx[d];
                    cy += ddy[d];

                    if(cur < lineSize) {
                        map[cx][cy] = line[cur++];
                    } else {
                        map[cx][cy] = 0;
                    }
                }
                d = (d + 1) % 4;
            }
        }
    }
}
