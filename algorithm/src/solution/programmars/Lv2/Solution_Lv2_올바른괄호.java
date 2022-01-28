package solution.programmars.Lv2;

import java.util.Stack;

public class Solution_Lv2_올바른괄호 {

    public static void main(String[] args) {

        System.out.println(solution("()()"));
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (cur == '(')
                stack.push(cur);
            else if (cur == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }
}
