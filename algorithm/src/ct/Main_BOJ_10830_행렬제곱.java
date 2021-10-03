package ct;

import java.util.Scanner;

public class Main_BOJ_10830_행렬제곱 {

    static int T = 1000;
    static int[][] m;
    static int N;
    static long B;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextLong();
        m = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m[i][j] = sc.nextInt() % T;
            }
        }

        int[][] mm = matrix(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mm[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrix(long y) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) { // 곱했을때 자기 자신이 나오기 위한 배열
            res[i][i] = 1;
        }

        while (y > 0L) {
            if (y % 2 == 1L) {
                res = multiple(res, m);
            }
            y /= 2L;
            m = multiple(m, m);
        }

        return res;
    }

    private static int[][] multiple(int[][] r, int[][] x) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int t = 0;
                for (int k = 0; k < N; k++) {
                    t += r[i][k] * x[k][j];
                }
                res[i][j] = t % T;
            }
        }

        return res;
    }
}
