package solution.programmars.Lv1;

import java.util.Stack;

public class Solution_Lv1_크레인인형뽑기게임 {
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int boardLen = board.length;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < boardLen; i++) {
                if (board[i][move - 1] != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == board[i][move - 1]) {
                            stack.pop();
                            answer += 2;
                        } else
                            stack.push(board[i][move - 1]);
                    } else
                        stack.push(board[i][move - 1]);

                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
