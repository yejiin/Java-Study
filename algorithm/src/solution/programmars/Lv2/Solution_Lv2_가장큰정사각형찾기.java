package solution.programmars.Lv2;

public class Solution_Lv2_가장큰정사각형찾기 {

    public int solution(int [][]board) {
        int result = 0;

        if (board.length == 1 && board[0].length == 1) {
            if (board[0][0] == 1)
                return 1;
            return 0;
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {

                if (board[i][j] == 1) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                    result = Math.max(result, board[i][j]);
                }
            }
        }
        return result * result;
    }
}
