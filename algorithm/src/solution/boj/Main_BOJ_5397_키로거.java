package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 강산이의 비밀번호를 알아내는 프로그램 작성
 *
 * 풀이
 * left stack, right stack
 * 1. '-' 이면 left stack pop
 * 2. '<' 이면 left stack pop -> right stack push (left stack isEmpty 넘어감)
 * 3. '>' 이면 right stack pop -> left stack push (right stack isEmpty 넘어감)
 * 4. 문자면 left stack push
 *
 * input : 길이가 L인 문자열 (1 <= L <= 1,000,000)
 * output: 강산이의 비밀번호
 *
 */
public class Main_BOJ_5397_키로거 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(in.readLine());

        for (int t = 0; t < tc; t++) {
            String str = in.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char key = str.charAt(i);
                switch (key) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    default:
                        left.push(key);
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while(!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
