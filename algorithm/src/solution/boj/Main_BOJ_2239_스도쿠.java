package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_2239_스도쿠 {

    static int[][] board;
    static ArrayList<int[]> zeroList;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        zeroList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String str = in.readLine();
            for (int j = 0; j < 9; j++) {
                int n = str.charAt(j) - '0';
                if (n == 0)
                    zeroList.add(new int[]{i, j});
                board[i][j] = n;
            }
        }
        doSudoku(0);
    }

    // dfs, 백트래킹
    private static void doSudoku(int index) {

        if (index == zeroList.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        boolean[] check = new boolean[10];  // 숫자가 사용되었는지 확인하는 배열

        int x = zeroList.get(index)[0];
        int y = zeroList.get(index)[1];

        for (int i = 0; i < 9; i++) {  // 열 체크
            if (board[x][i] != 0)
                check[board[x][i]] = true;
        }

        for (int i = 0; i < 9; i++) {  // 행 체크
            if (board[i][y] != 0)
                check[board[i][y]] = true;
        }

        int startX = (x/3) * 3;
        int startY = (y/3) * 3;
        for (int i = startX; i < startX + 3; i++) {  // 사각형 체트
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] != 0)
                    check[board[i][j]] = true;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!check[i]) {
                board[x][y] = i;
                doSudoku(index + 1);
                board[x][y] = 0;
            }
        }
    }
}
