package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 출력 : 격자 밖으로 나간 모래의 양
public class Main_BOJ_20057_마법사상어와토네이도 {

    static int N;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};  // 왼쪽, 아래쪽, 오른쪽, 위쪽
    static int[] dy = {-1, 0, 1, 0};

    static int[][][] dr = {
            {{0, -2, 5}, {-1, -1, 10}, {1, -1, 10}, {-2, 0, 2}, {-1, 0, 7}, {1, 0, 7}, {2, 0, 2}, {-1, 1, 1}, {1, 1, 1}},
            {{2, 0, 5}, {1, -1, 10}, {1, 1, 10}, {0, -2, 2}, {0, -1, 7}, {0, 1, 7}, {0, 2, 2}, {-1, -1, 1}, {-1, 1, 1}},
            {{0, 2, 5}, {-1, 1, 10}, {1, 1, 10}, {-2, 0, 2}, {-1, 0, 7}, {1, 0, 7}, {2, 0, 2}, {-1, -1, 1}, {1, -1, 1}},
            {{-2, 0, 5}, {-1, -1, 10}, {-1, 1, 10}, {0, -2, 2}, {0, -1, 7}, {0, 1, 7}, {0, 2, 2}, {1, -1, 1}, {1, 1, 1}}
    };

    static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(in.readLine());
        
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        int x = N / 2, y = N / 2;  // 가운데 좌표
        int d = 0;  // +1 -> %4 연산으로 방향 구하기
        int n = 1;  // 이동할 크기
        int nCnt = 0;  // 1이면 n 유지, 0이면 n + 1 (2번 이동 후 n의 크기를 증가시키기 위해)

        while (true) {
            for (int i = 0; i < n; i++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                x = nx;
                y = ny;

                moveSand(x, y, d);
            }

            if (x == 0 && y == 0)
                break;

            d = (d + 1) % 4;  // 방향 전환

            nCnt = (nCnt + 1) % 2;
            if (nCnt == 0)
                n++;
        }
        System.out.println(result);
    }

    private static void moveSand(int x, int y, int d) {
        // 이동시킬 위치의 모래의 양
        int sand = map[x][y];
        map[x][y] = 0;

        int moved = 0;

        for (int i = 0; i < 9; i++) {
            int nx = x + dr[d][i][0];
            int ny = y + dr[d][i][1];

            int nextMoved = (int)((double)sand * ((double)dr[d][i][2] / 100));
            moved += nextMoved;

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                result += nextMoved;
            else
                map[nx][ny] += nextMoved;
        }

        // 비율만큼 이동 후 남은 모래 이동
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
            result += sand - moved;
        } else {
            map[nx][ny] += sand - moved;
        }
    }
}
