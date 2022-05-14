package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17281_야구 {
    static int N;  // 이닝 수
    static int[][] hitterResult;  // 각 이닝 별 타자의 결과

    static int[] orders;
    static boolean[] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        hitterResult = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 9; j++) {
                hitterResult[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        orders = new int[8]; // 4번 제외하고 순서 정함
        visited = new boolean[8];
        permutation(0);

        System.out.println(result);
    }

    private static void permutation(int cnt) {
        // 타자 번호 0번 부터, 0번은 순서상 4번으로
        if (cnt == 8) {
            int[] hitOrders = new int[9];
            System.arraycopy(orders, 0, hitOrders, 0, 8);
            for (int i = 8; i >= 4; i--)
                hitOrders[i] = hitOrders[i - 1];
            hitOrders[3] = 0;
            result = Math.max(result, calcScore(hitOrders));
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visited[i])
                continue;

            orders[cnt] = i + 1;
            visited[i] = true;

            permutation(cnt + 1);
            visited[i] = false;
        }
    }

    private static int calcScore(int[] hitOrders) {
        boolean[] base = new boolean[3];
        int hittingNum = 0;  // 공을 친 순서
        int score = 0;
        int outCnt;

        // N 이닝동안 진행
        for (int i = 0; i < N; i++) {
            Arrays.fill(base, false);
            outCnt = 0;
            while(true) {
                int hit = hitterResult[i][hitOrders[(hittingNum++ % 9)]];

                if (hit == 0) {
                    if (++outCnt == 3)
                        break;
                } else if (hit < 4) {
                    for (int b = 2; b >= 0; b--) {
                        if (b + hit > 2) {
                            if (base[b])
                                score++;
                        } else {
                            if (base[b])
                                base[b + hit] = true;
                        }
                        base[b] = false;
                    }
                    base[hit - 1] = true;
                } else if (hit < 5) {
                    for (int k = 0; k < 3; k++) {
                        if(base[k]) {
                            score++;
                            base[k] = false;
                        }
                    }
                    score++;
                }
            }
        }
        return score;
    }
}
