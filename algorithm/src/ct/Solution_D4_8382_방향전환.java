package ct;

import java.util.Scanner;

public class Solution_D4_8382_방향전환 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int X = Math.abs(x2 - x1);  // 상대 좌표. 원점에서 시작하게
            int Y = Math.abs(y2 - y1);
            int max = Math.max(X, Y);

            int kun = X + Y;  // 군 (kun, 0)
            int val = 0;

            if (kun % 2 == 0) {
                val = 2 * kun;  // 짝수 2k
            } else {
                val = 2 * kun - 1;  // 홀수 2k - 1
            }

            int diff = (kun - max) * 2;  // (군, 0)에서 중앙을 향해 한칸 이동할 때마다 2씩 줄어듦
            val = val - diff;
            System.out.println("#" + tc + " " + val);
        }
    }
}
