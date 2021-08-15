package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 10; tc++) {
            int TC = Integer.parseInt(in.readLine());
            sb.append("#").append(TC).append(" ");

            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            Queue<Integer> queue = new LinkedList<>();
            int cnt = 0; // 10보다 큰 숫자 개수

            for (int i = 0; i < 8; i++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);

                if (num >= 10)
                    cnt++;
            }

            boolean flag = false;
            while (true) {
                for (int c = 1; c <=5 ;c++) {
                    int first = queue.poll();
                    int temp = first -c;
                    if (first >= 10 && temp < 10)
                        cnt--;
                    if (temp < 0)
                        temp = 0;

                    queue.offer(temp);

                    if (cnt == 0 && temp <= 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;
            }

            for (int i = 0; i < 8; i++)
                sb.append(queue.poll()).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
