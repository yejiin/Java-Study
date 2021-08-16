package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int CNT = Integer.parseInt(in.readLine());

        int[][] board = new int[100][100];

        int count = 0;
        for (int c = 0; c < CNT; c++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    if (board[i][j] == 0) {
                        count++;
                        board[i][j] = 1;
                    }
                }
            }

        }

        System.out.println(count);
    }

}
