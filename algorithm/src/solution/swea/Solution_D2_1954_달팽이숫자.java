package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1954_달팽이숫자 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(in.readLine());

        int[][] snail;
        for (int i = 1; i <= tc; i++) {
            sb.append("#").append(i).append("\n");

            int n = Integer.parseInt(in.readLine());

            snail = new int[n][n];

            int[] dx = { 0, 1, 0, -1 };
            int[] dy = { 1, 0, -1, 0 };
            int d = 0;

            int num = 1;

            int x = 0;
            int y = 0;
            snail[x][y] = num++;
            while (num <= (n * n)) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || snail[nx][ny] != 0) {
                    d = (d + 1) % 4;
                    continue;
                }
                snail[nx][ny] = num++;
                x = nx;
                y = ny;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(snail[j][k]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}