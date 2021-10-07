package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

    static int N, X;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            for (int i = 0; i < N; i++) { // 가로방향

                int roadCnt = 1; // 평지 개수
                boolean down = false; // 내리막인지 아닌지
                int j = 1;
                for (; j < N; j++) {

                    if (map[i][j] == map[i][j - 1]) { // 현재 지형과 전 지형의 높이가 같을 때

                        roadCnt++;
                        if (down && roadCnt == X) {
                            roadCnt = 0;
                            down = false;
                        }

                    } else if (map[i][j] < map[i][j - 1]) { // 현재 지형이 전 지형의 높이보다 낮을 때

                        if (map[i][j - 1] - map[i][j] > 1)
                            break;
                        else {
                            if (!down) {
                                roadCnt = 1;
                                down = true;
                            } else {
                                if (roadCnt < X)
                                    break;
                                else
                                    roadCnt = 1;
                            }
                        }

                    } else if (map[i][j] > map[i][j - 1]) { // 현재 지형이 전 지형의 높이보다 높을 때

                        if (map[i][j] - map[i][j - 1] > 1)
                            break;
                        else {
                            if (roadCnt < X)
                                break;
                            else {
                                roadCnt = 1;
                                down = false;
                            }
                        }
                    }
                }

                if (j == N && (roadCnt >= X || !down))
                    result++;

            }

            for (int j = 0; j < N; j++) { // 세로방향
                int roadCnt = 1;
                boolean down = false;
                int i = 1;
                for (; i < N; i++) {

                    if (map[i][j] == map[i - 1][j]) {

                        roadCnt++;
                        if (down && roadCnt == X) {
                            roadCnt = 0;
                            down = false;
                        }

                    } else if (map[i][j] < map[i - 1][j]) {
                        if (map[i - 1][j] - map[i][j] > 1)
                            break;
                        else {
                            if (!down) {
                                roadCnt = 1;
                                down = true;
                            } else if (down) {
                                if (roadCnt < X)
                                    break;
                                else
                                    roadCnt = 1;
                            }
                        }
                    } else if (map[i][j] > map[i - 1][j]) {
                        if (map[i][j] - map[i - 1][j] > 1)
                            break;
                        else {
                            if (roadCnt < X)
                                break;
                            else {
                                roadCnt = 1;
                                down = false;
                            }
                        }
                    }
                }

                if (i == N && (roadCnt >= X || !down))
                    result++;

            }
            System.out.println("#" + tc + " " + result);
        }

    }
}
