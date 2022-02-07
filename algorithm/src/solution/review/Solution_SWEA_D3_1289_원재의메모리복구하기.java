package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_D3_1289_원재의메모리복구하기 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            String str = in.readLine();
            int count = 0;
            if (str.charAt(0) == '1')
                count++;

            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(i - 1))
                    count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
