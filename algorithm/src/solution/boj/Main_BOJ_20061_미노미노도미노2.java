package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 출력 : 블록을 모두 놓았을 때 얻은 점수,
//       타일이 들어있는 칸의 개수
public class Main_BOJ_20061_미노미노도미노2 {

    static int N; // 블록을 놓은 횟수
    static int[][] green, blue;
    static int[] blueT = {0, 1, 3, 2};
    static int score;  // 점수


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        green = new int[6][4];
        blue = new int[6][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int t = Integer.parseInt(st.nextToken());  // 블록을 놓을 정보
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 초록색 보드로 이동
            moveBoard(green, t, y);

            // 파랑색 보드로 이동
            moveBoard(blue, blueT[t], x);  // 파랑색 보드는 x, y 위치 바꿈
        }
        System.out.println(score);
        System.out.println(count(green) + count(blue));
    }

    private static void moveBoard(int[][] board, int t, int y) {

        for (int i = 0; i <= 5; i++) {

            // 보드의 경계를 만날 경우
            if (i == 5) {
                board[i][y] = 1;
                if (t == 2) // t는 2일 때, 오른쪽블록
                    board[i][y + 1] = 1;
                else if (t == 3)
                    board[i - 1][y] = 1;
            } else {
                // t 는 2일 때, 오른쪽 블록이 다른 블록을 만날 경우와 왼쪽 블록이 다른 블록을 만날 경우
                if ((t == 2 && board[i + 1][y + 1] == 1) || board[i + 1][y] == 1) {
                    board[i][y] = 1;
                    if (t == 2)
                        board[i][y + 1] = 1;
                    else if (t == 3)
                        board[i - 1][y] = 1;
                    break;
                }
            }
        }
        checkRow(board);
    }

    private static void checkRow(int[][] board) {

        // 행 가득찬 경우 확인, 한 행씩
        for (int i = 0; i <= 5; i++) {
            int cnt = 0;

            for (int j = 0; j <= 3; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                }
            }

            // 행이 가득찬 경우
            if (cnt == 4) {
                Arrays.fill(board[i], 0);
                score++;

                // 옮기기
                for (int j = i - 1; j >= 0; j--) {
                    System.arraycopy(board[j], 0, board[j + 1], 0, board[j].length);
                }
                Arrays.fill(board[0], 0);
            }
        }

        // 연한 칸에 블록이 있는 경우
        int n = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] == 1) {
                    n++;
                    break;
                }
            }
        }

        if (n == 1) {
            for (int i = 4; i >= 0; i--) {
                System.arraycopy(board[i], 0, board[i + 1], 0, board[i].length);
            }
            Arrays.fill(board[1], 0);
        } else if (n == 2) {
            for (int i = 3; i >= 0; i--) {
                System.arraycopy(board[i], 0, board[i + 2], 0, board[i].length);
            }
            Arrays.fill(board[0], 0);
            Arrays.fill(board[1], 0);
        }
    }

    private static int count(int[][] board) {
        int cnt = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}
