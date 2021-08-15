package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2493_탑 {

//	static String str = "5\r\n" + "6 9 5 7 4";

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new StringReader(str));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(in.readLine());
        int[] top = new int[N + 1];

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 배열
        int[] res = new int[N + 1];

        // 스택에 top배열 인덱스 저장
        Stack<Integer> stack = new Stack<>();

        stack.push(1);

        for (int i = 2; i <= N; i++) {
            int before = stack.pop();

            // 바로 왼쪽 탑의 높이가 자신보다 낮을 때
            if (top[before] < top[i]) {
                // 왼쪽에 있는 탑 중 자신보다 높은 탑 찾기
                while (!stack.isEmpty()) {
                    int b = stack.pop();
                    if (top[b] > top[i]) {
                        res[i] = b;
                        stack.push(b);
                        stack.push(i);
                        break;
                    }
                }
            // 바로 왼쪽 탑의 높이가 자신보다 높을 때
            } else if (top[before] > top[i]) {
                res[i] = before;
                stack.push(before);
                stack.push(i);
            }

            // 왼쪽에 있는 탑 중 자신보다 높은 탑이 없을 때
            if (stack.isEmpty()) {
                res[i] = 0;
                stack.push(i);
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }

}
