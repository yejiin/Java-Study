package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_15686_치킨배달 {

    static int N;
    static int M;
    static int result = Integer.MAX_VALUE;

    static int[][] city;
    static List<int[]> chickens;
    static int[] possibleChickens;

    // 치킨 거리 = 집에서 가장 가까운 치킨집 사이의 거리
    // 도시의 치킨 거리 = 모든 집의 치킨 거리의 합
    public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집 개수

        city = new int[N][N];
        chickens = new ArrayList<>();
        possibleChickens = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());
                city[i][j] = data;
                if (data == 2) {
                    chickens.add(new int[] { i, j });
                }
            }
        }
        combination(0, 0);
        System.out.println(result);
    }

    // 조합
    private static void combination(int cnt, int start) {
        // 기저조건
        if (cnt == M) {
            result = Math.min(result, cityDistance()); // 치킨 거리 계산
            return;
        }

        // 유도 코드
        for (int i = start; i < chickens.size(); i++) {
            possibleChickens[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    // 치킨 거리 계산
    private static int cityDistance() {

        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                    for (int pc : possibleChickens) {
                        int distance = 0;
                        int r = chickens.get(pc)[0];
                        int c = chickens.get(pc)[1];

                        distance += Math.abs(r - i);
                        distance += Math.abs(c - j);
                        min = Math.min(min, distance);
                    }
                    sum += min;
                }

            }

        }

        return sum;
    }

}
