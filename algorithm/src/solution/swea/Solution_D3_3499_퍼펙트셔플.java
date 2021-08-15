package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(in.readLine());

        Queue<String> queue1 = new LinkedList<>();  // 앞쪽 절반
        Queue<String> queue2 = new LinkedList<>();  // 뒤쪽 절반

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(in.readLine());

            //  짝수인지 홀수인지 구분
            int d = 0;
            if (N % 2 == 0) {
                d = N / 2;
            } else {
                d = N / 2 + 1;
            }

            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < d; i++) {
                queue1.offer(st.nextToken());
            }

            for (int i = d; i < N; i++) {
                queue2.offer(st.nextToken());
            }

            // 새로운 덱
            Queue<String> res = new LinkedList<>();
            while (true) {
                String d1 = queue1.poll();
                if (d1 == null)
                    break;
                res.offer(d1);

                String d2 = queue2.poll();
                if (d2 == null)
                    break;
                res.offer(d2);
            }
            sb.append("#").append(tc).append(" ");
            while (!res.isEmpty()) {
                sb.append(res.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
