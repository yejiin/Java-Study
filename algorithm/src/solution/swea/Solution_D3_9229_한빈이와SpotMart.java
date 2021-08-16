package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와SpotMart {

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");

            int N = Integer.parseInt(st.nextToken()); // 과자 봉지의 개수
            int M = Integer.parseInt(st.nextToken()); // 무게ㅎ 합 제한

            Integer[] weight = new Integer[N];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(weight, Collections.reverseOrder());

            int max = 0;
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    sum = weight[i] + weight[j];
                    if (sum <= M) {
                        max = Math.max(sum, max);
                    }
                    sum = 0;
                }
            }
            max = (max == 0) ? -1 : max;
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

}
