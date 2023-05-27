package solution.programmars.Lv3;

/**
 * 정확성 테스트 100%
 * 효율성 테스트 100%
 */
public class Solution_Lv3_파괴되지않은건물 {

    public int solution(int[][] board, int[][] skill) {
        int answer = board.length * board[0].length; // 총 개수에서 파괴된만큼 삭제

        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for (int[] s : skill) {
            int degree;
            if (s[0] == 1) {
                degree = -s[5];
            } else {
                degree = s[5];
            }

            sum[s[1]][s[2]] += degree;
            sum[s[1]][s[4] + 1] -= degree;
            sum[s[3] + 1][s[4] + 1] += degree;
            sum[s[3] + 1][s[2]] -= degree;
        }

        // 가로 방향 누적합
        for (int j = 1; j < sum[0].length; j++) {
            for (int i = 0; i < sum.length; i++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        // 사로 방향 누적합
        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] <= 0) {
                    answer--;
                }
            }
        }

        return answer;
    }
}
