package solution.programmars.Lv2;

import java.util.Stack;

public class Solution_Lv2_짝지어제거하기 {

    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        int answer = -1;

        Stack<Character> front = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (front.isEmpty()) {
                front.push(s.charAt(i));
                continue;
            }

            Character fchar = front.peek();
            Character cur = s.charAt(i);
            if (fchar == cur)
                front.pop();
            else
                front.push(cur);
        }

        if (front.isEmpty())
            answer = 1;
        else
            answer = 0;

        return answer;
    }
}
