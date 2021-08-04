package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기 {

    public static void main(String[] args) throws NumberFormatException, IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        int N = 0;
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(in.readLine());

            sb.append("#").append(tc).append(" ");

            int[][] farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String VALUE = in.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = Integer.parseInt(String.valueOf(VALUE.charAt(j)));
                }
            }

            int sum = 0;

            int half = N / 2;
            if (half != 0) {

                for (int i = 0; i < half; i++) {
                    int d = i % half;
                    for (int j = (half - 1); j > (half - 1) - d; j--) {
                        sum += farm[i][j];
                    }

                    sum += farm[i][half];

                    for (int j = (half + 1); j < (half + 1) + d; j++) {
                        sum += farm[i][j];
                    }

                }

                for (int k = 0; k < N; k++) {
                    sum += farm[half][k];
                }

                for (int i = half + 1; i < N; i++) {
                    int d = i % (half + 1);
                    for (int j = half - 1; j > d; j--) {
                        sum += farm[i][j];
                    }
                    sum += farm[i][half];

                    for (int j = half + 1; j < (N - 1) - d; j++) {
                        sum += farm[i][j];
                    }

                }

            } else {
                sum += farm[0][0];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
