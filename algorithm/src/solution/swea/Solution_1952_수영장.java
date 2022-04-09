package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int[] price = new int[4];
            int[] plan = new int[13];
            int[] minPrice = new int[13];
            int[] result = new int[13];  // 누적 비용

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // 1일 요금과 1달 요금 비교
            for (int i = 1; i <= 12; i++) {
                minPrice[i] = Math.min(plan[i] * price[0], price[1]);
            }

            // 3달 요금 비교
            for (int i = 1; i <= 12; i++) {
                result[i] = result[i - 1] + minPrice[i];
                if (i - 3 >= 0) {
                    if(result[i] > result[i - 3] + price[2])  {
                        result[i] = result[i - 3] + price[2];
                    }
                }
            }

            // 1년 요금 비교
            if (result[12] > price[3])
                result[12] = price[3];

            sb.append("#").append(tc).append(" ").append(result[12]).append("\n");
        }
        System.out.println(sb);
    }
}
