package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 출력 : 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값 구하기
// DFS
// 상, 하, 좌, 우 움직여 보며 board 전체가 이동하는 것이 Point <- board 복사 필수
public class Main_BOJ_12100_2048_Easy {

    static int N;
    static int[][] board;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > max)
                    max = board[i][j];
            }
        }

        dfs(0, board);
        System.out.println(max);
    }

    private static void dfs(int cnt, int[][] board) {
        if (cnt == 5) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int[][] nextBoard = copyBoard(board);
            moveBoard(d, nextBoard);
            dfs(cnt + 1, nextBoard);
        }
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++)
            System.arraycopy(board[i], 0, temp[i], 0, N);

        return temp;
    }

    private static void moveBoard(int d, int[][] board) {
        int isMoved = -1;  // 이미 합쳐진 블록
        if (d == 0) {
            for (int j = 0; j < N; j++) {
                isMoved = -1;
                for (int i = 1; i < N; i++) {
                    if (board[i][j] == 0)  // 0인 경우 x
                        continue;

                    for (int k = i - 1; k >= 0; k--) {
                        if (isMoved < k && board[k][j] == board[k + 1][j]) {  // 합쳐지는 상황
                            board[k][j] *= 2;
                            board[k + 1][j] = 0;
                            isMoved = k;
                            max = Math.max(max, board[k][j]);
                            break;
                        }

                        if (board[k][j] == 0) {
                            board[k][j] = board[k + 1][j];
                            board[k + 1][j] = 0;
                        }
                    }
                }
            }

        } else if (d == 1) {
            for (int j = 0; j < N; j++) {
                isMoved = N;
                for (int i = N - 2; i >= 0; i--) {
                    if (board[i][j] == 0)  // 0인 경우 x
                        continue;

                    for (int k = i + 1; k < N; k++) {
                        if (isMoved > k && board[k][j] == board[k - 1][j]) {  // 합쳐지는 상황
                            board[k][j] *= 2;
                            board[k - 1][j] = 0;
                            isMoved = k;
                            max = Math.max(max, board[k][j]);
                            break;
                        }

                        if (board[k][j] == 0) {
                            board[k][j] = board[k - 1][j];
                            board[k - 1][j] = 0;
                        }
                    }
                }
            }
        } else if (d == 2) {
            for (int i = 0; i < N; i++) {
                isMoved = -1;
                for (int j = 1; j < N; j++) {
                    if (board[i][j] == 0)  // 0인 경우 x
                        continue;

                    for (int k = j - 1; k >= 0; k--) {
                        if (isMoved < k && board[i][k] == board[i][k + 1]) {  // 합쳐지는 상황
                            board[i][k] *= 2;
                            board[i][k + 1] = 0;
                            isMoved = k;
                            max = Math.max(max, board[i][k]);
                            break;
                        }

                        if (board[i][k] == 0) {
                            board[i][k] = board[i][k + 1];
                            board[i][k + 1] = 0;
                        }
                    }
                }
            }
        } else if (d == 3) {
            for (int i = 0; i < N; i++) {
                isMoved = N;
                for (int j = N - 2; j >= 0; j--) {
                    if (board[i][j] == 0)  // 0인 경우 x
                        continue;

                    for (int k = j + 1; k < N; k++) {
                        if (isMoved > k && board[i][k] == board[i][k - 1]) {  // 합쳐지는 상황
                            board[i][k] *= 2;
                            board[i][k - 1] = 0;
                            isMoved = k;
                            max = Math.max(max, board[i][k]);
                            break;
                        }
                        if (board[i][k] == 0) {
                            board[i][k] = board[i][k - 1];
                            board[i][k - 1] = 0;
                        }
                    }
                }
            }
        }
    }
}
