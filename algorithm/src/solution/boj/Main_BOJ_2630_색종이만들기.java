package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2630_색종이만들기 {

    static int N;
    static int[][] map;
    static int wCnt, bCnt;

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

        divide(0, 0, N);
        System.out.println(wCnt);
        System.out.println(bCnt);
    }

    private static void divide(int row, int col, int size) {

        int sum = 0;

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                sum += map[i][j];
            }
        }

        if (sum == 0)
            wCnt++;
        else if (sum == size * size)
            bCnt++;
        else {
            int half = size / 2;
            divide(row, col, half);
            divide(row + half, col, half);
            divide(row, col + half, half);
            divide(row + half, col + half, half);
        }
    }
}
