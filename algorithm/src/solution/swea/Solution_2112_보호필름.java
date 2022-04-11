package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(in.readLine());
            int D = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] film = new int[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MAX_VALUE;

            if (check(film, D, W, K) || K == 1) {
                result = 0;
            } else {
                // 약품 투입할 행 선택
                chooseRow(0, 0, film, D, W, K);
            }

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }


    private static void chooseRow(int cnt, int injectionCnt, int[][] film, int D, int W, int K) {

        if (cnt == D) {
            if (injectionCnt < result) {
                if (check(film, D, W, K)){
                    result = Math.min(result, injectionCnt);
                }
            }
            return;
        }

        if (result >= injectionCnt) {
            // A 약품을 투과한 경우
            int[][] tempFilm = copy(film, D, W);
            inject(0, tempFilm, cnt);
            chooseRow(cnt + 1, injectionCnt + 1, tempFilm, D, W, K);

            // B 약품을 투과한 경우
            inject(1, tempFilm, cnt);
            chooseRow(cnt + 1, injectionCnt + 1, tempFilm, D, W, K);

            // 약품을 투과하지 않은 경우
            chooseRow(cnt + 1, injectionCnt, film, D, W, K);
        }
    }

    private static boolean check(int[][] film, int D, int W, int K) {

        for (int i = 0; i < W; i++) {
            int[] cnt = new int[2];

            if (film[0][i] == 0)
                cnt[0]++;
            else
                cnt[1]++;

            for (int j = 1; j < D; j++) {

                // 위 셀의 득성과 동일한지 확인
                if (film[j - 1][i] != film[j][i])
                    cnt[(film[j][i] + 1) % 2] = 0;

                cnt[film[j][i]]++;

                if (cnt[film[j][i]] >= K)
                    break;
            }

            if (cnt[0] < K && cnt[1] < K)
                return false;
        }
        return true;
    }

    private static int[][] copy(int[][] film, int D, int W) {
        int[][] temp = new int[D][W];
        for (int i = 0; i < D; i++) {
            System.arraycopy(film[i], 0, temp[i], 0, W);
        }
        return temp;
    }

    private static void inject(int drug, int[][] film, int row) {
        for (int i = 0; i < film[0].length; i++) {
            film[row][i] = drug;
        }
    }
}
