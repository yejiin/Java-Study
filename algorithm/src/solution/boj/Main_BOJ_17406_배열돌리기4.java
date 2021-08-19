package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17406_배열돌리기4 {

    static int[][] rotationNo;
    static boolean[] isSelected;
    static int[] order;

    static int N, M, K;
    static int arr[][];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수

        arr = new int[N + 1][M + 1];

        // 배열 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotationNo = new int[K][3];
        order = new int[K];
        isSelected = new boolean[K];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(in.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            rotationNo[k] = new int[] { R, C, S };
        }
        permutation(0);
        System.out.println(result);

    }

    private static void permutation(int cnt) {

        if (cnt == K) {
            int[][] res = copyArray(arr);
            for (int i = 0; i < K; i++) {
                res = rotation(res, rotationNo[order[i]][0], rotationNo[order[i]][1], rotationNo[order[i]][2]);
            }
            result = Math.min(result, calcMin(res));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (isSelected[i])
                continue;
            order[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    private static int[][] rotation(int[][] arr, int r, int c, int s) {

        int[][] res = copyArray(arr);

        int temp = 0; // 배열의 첫번째 숫자 저장

        for (int i = 0; i < s; i++) {
            // i 행, j 열
            int startI = r - s;
            int endI = r + s;
            int startJ = c - s;
            int endJ = c + s;

            temp = res[startI + i][endJ - i];

            // 윗줄 회전
            for (int j = endJ - i; j > startJ + i; j--) {
                res[startI + i][j] = res[startI + i][j - 1];
            }

            // 왼쪽줄 회전
            for (int j = startI + i; j < endI - i; j++) {
                res[j][startJ + i] = res[j + 1][startJ + i];
            }

            // 아래줄 회전
            for (int j = startJ + i; j < endJ - i; j++) {
                res[endI - i][j] = res[endI - i][j + 1];
            }

            // 오른쪽줄 회전
            for (int j = endI - i; j > startI + i; j--) {
                res[j][endJ - i] = res[j - 1][endJ - i];
            }

            res[startI + 1 + i][endJ - i] = temp;

        }
        return res;
    }

    private static int[][] copyArray(int[][] arr) {

        int[][] res = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            System.arraycopy(arr[i], 0, res[i], 0, M + 1);
        }

        return res;
    }

    private static int calcMin(int[][] res) {
        int sum = 0;
        int minS = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum += res[i][j];
            }
            minS = Math.min(sum, minS);
            sum = 0;
        }

        return minS;
    }

}