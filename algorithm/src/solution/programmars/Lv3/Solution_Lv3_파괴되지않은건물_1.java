package solution.programmars.Lv3;

/**
 * 정확성 테스트 100%
 * 효율성 테스트 0%
 */
public class Solution_Lv3_파괴되지않은건물_1 {

    public int solution(int[][] board, int[][] skill) {
        int answer = board.length * board[0].length; // 총 개수에서 파괴된만큼 삭제

        for (int[] s : skill) {
            if (s[0] == 1) {  // 공격
                answer -= attack(s, board);
            } else {  // 회복
                answer += recover(s, board);
            }
        }
        return answer;
    }

    // 파괴된 건물 수 return
    private int attack(int[] skill, int[][] board) {
        int count = 0;
        for (int i = skill[1]; i <= skill[3]; i++) {
            for (int j = skill[2]; j <= skill[4]; j++) {
                if (board[i][j] > 0 && board[i][j] <= skill[5]) {
                    count++;
                }
                board[i][j] -= skill[5];
            }
        }
        return count;
    }

    // 파괴 -> 회복된 건물 수 return
    private int recover(int[] skill, int[][] board) {
        int count = 0;
        for (int i = skill[1]; i <= skill[3]; i++) {
            for (int j = skill[2]; j <= skill[4]; j++) {
                if (board[i][j] <= 0 && -board[i][j] < skill[5]) {
                    count++;
                }
                board[i][j] += skill[5];
            }
        }
        return count;
    }
}
