package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_1289_원재의메모리복구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        for (int i = 1; i <= n; i++) {
            int count = 0;

            String str = in.readLine();
            char ch[] = str.toCharArray();

            int len = ch.length;
            for (int j = 0; j < len; j++) {
                if (ch[j] == '1') {
                    for (int k = j; k < len; k++) {
                        if (ch[k] == '1') {
                            ch[k] = '0';
                        } else {
                            ch[k] = '1';
                        }

                    }
                    count += 1;
                }

            }

            System.out.printf("#%d %d%n", i, count);
        }

    }
}