package solution.programmars.Lv1;

import java.util.HashMap;
import java.util.Map;

public class Solution_Lv1_키패드누르기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        Map<Integer, Position> keypad = new HashMap<>();
        keypad.put(1, new Position(1, 1));
        keypad.put(2, new Position(1, 2));
        keypad.put(3, new Position(1, 3));
        keypad.put(4, new Position(2, 1));
        keypad.put(5, new Position(2, 2));
        keypad.put(6, new Position(2, 3));
        keypad.put(7, new Position(3, 1));
        keypad.put(8, new Position(3, 2));
        keypad.put(9, new Position(3, 3));
        keypad.put(0, new Position(4, 2));

        Position lpos = new Position(4, 1);
        Position rpos = new Position(4, 3);

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer += "L";
                lpos = keypad.get(number);
            } else if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                rpos = keypad.get(number);
            } else {
                Position npos = keypad.get(number);
                int l = Math.abs(lpos.x - npos.x) + Math.abs(lpos.y - npos.y);
                int r = Math.abs(rpos.x - npos.x) + Math.abs(rpos.y - npos.y);

                if (l < r) {
                    answer += "L";
                    lpos = keypad.get(number);
                } else if (l > r) {
                    answer += "R";
                    rpos = keypad.get(number);
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        lpos = keypad.get(number);
                    } else {
                        answer += "R";
                        rpos = keypad.get(number);
                    }
                }
            }
        }
        return answer;
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
