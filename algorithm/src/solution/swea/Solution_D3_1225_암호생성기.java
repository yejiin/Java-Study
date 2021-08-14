package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 10; tc++) {
            int TC = Integer.parseInt(in.readLine());
            sb.append("#").append(TC).append(" ");

            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            // 작업의 개수. 5개가 한 사이클
            int cycle = 0;
            // 10보다 큰 숫자 개수
            int cnt = 0;

            while (true) {
                int first = queue.poll();
                first = first - ++cycle;
                if (first < 10)
                    cnt++;

                if (first <= 0) {
                    first = 0;
                } else {
                    cnt++;
                }

                queue.offer(first);

//                if (cnt)
                if (cycle == 5)
                    cycle = 0;
            }

//            for (int i = 0; i < 8; i++)
//                sb.append(queue.poll()).append(" ");
//            sb.append("\n");
        }
        System.out.println(sb);
    }
}
