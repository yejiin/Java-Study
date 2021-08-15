package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {

    public static void main(String[] args) throws NumberFormatException, IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int tc =  0; tc < 10; tc++) {
            int TC = Integer.parseInt(in.readLine());
            sb.append("#").append(TC).append(" ");

            int[][] ladder = new int[100][100];
            int[] location = new int[2];


            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i< 100; i++) {
                if (ladder[99][i] == 2) {
                    location[0] = 99;
                    location[1] = i;
                }
            }

            int j = location[1];
            for (int i = location[0]; i >= 0; i--) {
                if ((j - 1) > 0 && ladder[i][j - 1] == 1) {
                    while ((j - 1) > 0 && ladder[i][j - 1] == 1) {
                        j--;
                        ladder[i][j] = 2;
                    }
                }

                if ((j + 1) < 100 && ladder[i][j + 1] == 1) {
                    while ((j + 1) < 100 && ladder[i][j + 1] == 1) {
                        j++;
                        ladder[i][j] = 2;
                    }
                }
            }
            sb.append(j);
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
