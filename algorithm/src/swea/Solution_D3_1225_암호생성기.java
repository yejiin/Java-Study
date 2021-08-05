package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기 {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int i2 = 0; i2 < 10; i2++) {
            int TC = Integer.parseInt(in.readLine());

            sb.append("#").append(TC).append(" ");

            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                deque.add(Integer.parseInt(st.nextToken()));

            }

            int cycle = 0;
            while (true) {
                boolean flag = false;
                boolean flag2 = false;
                for (int i = 0; i < 8; i++) {
                    int num = deque.pollFirst();
                    if (num >= 10) {
                        flag = true;
                    }
                    deque.add(num);
                }

                if (cycle == 5)
                    cycle = 0;
                int first = deque.pollFirst();
                first = first - ++cycle;

                if (first <= 0) {
                    first = 0;
                    flag2 = true;

                }
                deque.add(first);

                if (!flag && flag2)
                    break;

            }
            for (int i = 0; i < 8; i++) {
                sb.append(deque.pollFirst()).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
