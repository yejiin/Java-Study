package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// return : (0, 0) 까지 이동한 뒤, 격자 밖으로 나간 모래의 양 구하기
//
// 구현
// 1. N 크기에 맞춰 한 칸씩 이동
// 2. 이동할 때 일정한 비율로 흩날리기
public class Main_BOJ_20057_마법사상어와토네이도 {

    static int N;
    static int[][] sandMap;
    static int amountOutSand;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] rate = {
            {0, 0, 2, 0, 0},
            {0, 10, 7, 1, 0},
            {5, 0, 0, 0, 0},
            {0, 10, 7, 1, 0},
            {0, 0, 2, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        sandMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                sandMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moveTornado();

        System.out.println(amountOutSand);
    }

    private static void moveTornado() {
        // 가운데부터 한 칸씩 이동
        int x = N / 2;  // 시작점
        int y = N / 2;
        int d = 0;
        int mvCnt = 1;  // 움직이는 횟수

        while (true) {
            // 방향 바꿔서 같은 거리 이동
            for (int i = 0; i < 2; i++) {
                // 위치 설정 -> mvCnt 번 이동 -> 방향 변경
                for (int j = 0; j < mvCnt; j++) {
                    x += dx[d];
                    y += dy[d];

                    moveSand(x, y, d);

                    if (x == 0 && y == 0) {  // 토네이토 소멸
                        return;
                    }
                }
                d = (d + 1) % 4;
                rotateRate();
            }
            mvCnt++;
        }
    }

    private static void moveSand(int x, int y, int d) {
        int sand = sandMap[x][y];
        sandMap[x][y] = 0;

        int moved = 0;

        for (int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {

                int nextMoved = (int) ((double) sand * ((double) rate[i - x + 2][j - y + 2] / 100));
                moved += nextMoved;

                if (i < 0 || i >= N || j < 0 || j >= N) {
                    amountOutSand += nextMoved;
                } else {
                    sandMap[i][j] += nextMoved;
                }
            }
        }

        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N)
            amountOutSand += sand - moved;
        else {
            sandMap[nx][ny] += sand - moved;
        }
    }

    private static void rotateRate() {
        int[][] temp = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                temp[i][j] = rate[j][5 - 1 - i];
            }
        }
        rate = temp;
    }
}
