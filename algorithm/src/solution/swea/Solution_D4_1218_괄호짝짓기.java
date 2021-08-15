package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {

    public static void main(String[] args) throws NumberFormatException, IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        Character[] left = { '(', '[', '{', '<' };

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");

            int LEN = Integer.parseInt(in.readLine());
            boolean result = true;

            Stack<Character> stack = new Stack<>();

            String str = in.readLine();
            for (int i = 0; i < LEN; i++) {
                char c = str.charAt(i);
                if (Arrays.asList(left).contains(c)) {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        switch (c) {
                            case ')':
                                if (stack.peek() == '(') {
                                    stack.pop();
                                } else {
                                    result = false;
                                }
                                break;
                            case ']':
                                if (stack.peek() == '[') {
                                    stack.pop();
                                } else {
                                    result = false;
                                }
                                break;
                            case '}':
                                if (stack.peek() == '{') {
                                    stack.pop();
                                } else {
                                    result = false;
                                }
                                break;
                            case '>':
                                if (stack.peek() == '<') {
                                    stack.pop();
                                } else {
                                    result = false;
                                }
                                break;
                        }
                    }
                    if (!result)
                        break;
                }
            }
            if (!stack.isEmpty()) {
                result = false;
            }

            if (result) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }

        }
        System.out.println(sb);
    }

}
