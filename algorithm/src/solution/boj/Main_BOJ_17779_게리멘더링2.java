package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 출력 : 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값
public class Main_BOJ_17779_게리멘더링2 {

    static int N;
    static int[][] populations;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        populations = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= N; j++) {
                populations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // x, y, d1, d2 결정
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= y - 1; d1++) {
                    for (int d2 = 1; d2 <= N - y; d2++) {
                        if (x + d1 + d2 <= N) {
                            divide(x, y, d1, d2);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static void divide(int x, int y, int d1, int d2) {

        map = new int[N + 1][N + 1];  // 선거구 번호 저장

        // 5번 선거구 경계선
        for (int i = 0; i <= d1; i++) {
            map[x + i][y - i] = 5;
            map[x + d2 + i][y + d2 - i] = 5;
        }
        for (int i = 0; i <= d2; i++) {
            map[x + i][y + i] = 5;
            map[x + d1 + i][y - d1 + i] = 5;
        }

        // 1번 선거구
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {

                // 5번 선거구에 포함되는 구역 처리
                if (map[r][c] == 5)
                    break;
                map[r][c] = 1;
            }
        }

        // 2번 선거구
        for (int r = 1; r <= x + d2; r++) {
            for (int c = y + 1; c <= N; c++) {

                // 5번 선거구에 포함되는 구역 처리
                if (map[r][c] == 5) {  // 5번 선거구 경계선 바로 왼쪽인 경우
                    if (map[r][c - 1] == 2)
                        map[r][c - 1] = 0;
                    continue;
                }
                if (r > 1 && map[r - 1][c] == 0) { // 5번 선거구 경계선 안에 포한되어 있는 경우
                    map[r][c] = 0;
                    continue;
                }
                map[r][c] = 2;
            }
        }

        // 3번 선거구
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {

                // 5번 선거구에 포함되는 구역 처리
                if (map[r][c] == 5)
                    break;
                map[r][c] = 3;
            }
        }

        // 4번 선거구
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = y - d1 + d2; c <= N; c++) {

                // 5번 선거구에 포함되는 구역 처리
                if (map[r][c] == 5) {  // 5번 선거구 경계선 바로 왼쪽인 경우
                    if (map[r][c - 1] == 4)
                        map[r][c - 1] = 0;
                    continue;
                }
                if (r > 1 && map[r - 1][c] == 0) {  // 5번 선거구 경계선 안에 포한되어 있는 경우
                    map[r][c] = 0;
                    continue;
                }
                map[r][c] = 4;
            }
        }
        calcPopulation(map);
    }

    private static void calcPopulation(int[][] map) {
        int[] sumList = new int[5];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int num = map[i][j] == 0 ? 5 : map[i][j];
                sumList[num - 1] += populations[i][j];
            }
        }

        Arrays.sort(sumList);
        int diff = sumList[4] - sumList[0];

        result = Math.min(result, diff);
    }
}
