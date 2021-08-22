package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1992_쿼드트리 {

    static StringBuilder sb = new StringBuilder();
    static int[][] spaces;

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        spaces = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < N; j++) {
                spaces[i][j] = input.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);

    }

    private static void quadTree(int r, int c, int size) {

        if (isAvailable(r, c, size)) {
            return;
        }

        sb.append("(");
        int half = size / 2;
        quadTree(r, c, half);
        quadTree(r, c + half, half);
        quadTree(r + half, c, half);
        quadTree(r + half, c + half, half);
        sb.append(")");

    }

    private static boolean isAvailable(int r, int c, int size) {
        int sum = 0;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                sum += spaces[i][j];
            }
        }

        if (sum == size * size) {
            sb.append("1");
            return true;
        } else if (sum == 0) {
            sb.append("0");
            return true;
        }
        return false;
    }
}
