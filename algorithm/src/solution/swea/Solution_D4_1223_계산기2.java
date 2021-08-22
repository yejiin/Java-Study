package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {

    static int LEN;

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input_.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            LEN = Integer.parseInt(in.readLine());
            String postfix = getPostfix(in.readLine());
            sb.append("#").append(tc).append(" ").append(calcPostfix(postfix)).append("\n");
        }
        System.out.println(sb);
    }

    private static String getPostfix(String infix) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < LEN; i++) {
            char ch = infix.charAt(i);

            if (ch == '+') {
                while (!stack.isEmpty()) {
                    sb.append((char) stack.pop());
                }
                stack.add(ch);
            } else if (ch == '*') {
                stack.add(ch);
            } else {
                sb.append(ch - '0');
            }

        }

        while (!stack.isEmpty()) {
            sb.append((char) stack.pop());
        }

        return sb.toString();
    }

    private static int calcPostfix(String postfix) {

        int val = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < LEN; i++) {
            char ch = postfix.charAt(i);

            if (ch == '+') {
                val = stack.pop() + stack.pop();
                stack.push(val);
            } else if (ch == '*') {
                val = stack.pop() * stack.pop();
                stack.push(val);
            } else {
                stack.push(ch - '0');
            }
        }

        return val;
    }
}

