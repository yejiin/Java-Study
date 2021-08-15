package solution.swea;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten {

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            int maxDumpCnt = Integer.parseInt(in.readLine());
            int[] num = new int[100];

            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < 100; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            while (true) {
                Arrays.sort(num);
                num[99] -= 1;
                num[0] += 1;
                maxDumpCnt -= 1;
                if (maxDumpCnt == 0) {
                    break;
                }
            }
            Arrays.sort(num);
            sb.append(num[99] - num[0]);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
