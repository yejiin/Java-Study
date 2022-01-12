package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11723_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(in.readLine());
        int S = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            String operator = st.nextToken().trim();
            int operand = 0;

            switch (operator) {
                case "add":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    S |= (1 << operand);
                    break;
                case "remove":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    S &= ~(1 << operand);
                    break;
                case "check":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    sb.append((S & (1 << operand)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    operand = Integer.parseInt(st.nextToken()) - 1;
                    S ^= (1 << operand);
                    break;
                case "all":
                    S = (1 << 20) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
