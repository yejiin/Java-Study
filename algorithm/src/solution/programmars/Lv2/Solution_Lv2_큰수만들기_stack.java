package solution.programmars;

import java.util.Stack;


public class Solution_Lv2_큰수만들기_stack {

    public String solution(String number, int k) {
        int len = number.length() - k;

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < len; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}
