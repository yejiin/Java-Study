package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1158_요세푸스문제 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int K = Integer.parseInt(st.nextToken()); // k번째

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        while (queue.size() != 0) {
            cnt++;
            int temp = queue.poll();
            if (cnt == K) {
                sb.append(temp).append(", ");
                cnt = 0;
            } else {
                queue.offer(temp);
            }
        }

        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);

    }
}
