package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_Ladder1 {

    public static void main(String[] args) throws NumberFormatException, IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int tc = Integer.parseInt(in.readLine());
            sb.append("#").append(tc).append(" ");

            int[][] ladder = new int[100][100];

            int x = 0;
            int y = 0;

            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");

                for (int k = 0; k < 100; k++) {
                    ladder[j][k] = Integer.parseInt(st.nextToken());

                    if (ladder[j][k] == 2) {
                        x = j;
                        y = k;
                        break;
                    }
                }
            }

            for (; x >= 0; x--) {
                if ((y - 1) > 0 && ladder[x][y - 1] == 1) {
                    while ((y - 1) > 0 && ladder[x][y - 1] == 1) {
                        y--;
                        ladder[x][y] = 2;
                    }
                }

                if ((y + 1) < 100 && ladder[x][y + 1] == 1) {
                    while ((y + 1) < 100 && ladder[x][y + 1] == 1) {
                        y++;
                        ladder[x][y] = 2;
                    }

                }
            }
            int result = y;
            sb.append(result);
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
