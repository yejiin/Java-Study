package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1018_체스판다시칠하기 {

    static int N, M;
    static char[][] board;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        result = Integer.MAX_VALUE;
        changeBoard();
        System.out.println(result);
    }

    private static void changeBoard() {
        int[][] countB = new int[N][M];
        int[][] countW = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] == 'W')
                        countB[i][j] = 1;
                    else
                        countW[i][j] = 1;
                } else {
                    if (board[i][j] == 'B')
                        countB[i][j] = 1;
                    else
                        countW[i][j] = 1;
                }
            }
        }
        checkCount(countB);
        checkCount(countW);
    }

    private static void checkCount(int[][] cboard) {
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (cboard[i + k][j + l] == 1)
                            count++;
                    }
                }
                result = Math.min(result, count);
            }
        }
    }
}
