package solution.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5644_무선충전 {

    static int M, A;
    static int[] moveA, moveB;
    static ArrayList<BC> BCList;  // BC 정보 리스트

    // -, 상, 우, 하, 좌
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    static class BC {
        int x, y, c, p;

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            moveA = new int[M];
            moveB = new int[M];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            BCList = new ArrayList<>();
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                BCList.add(new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            System.out.println("#" + tc + " " + move());
        }
    }

    private static int move() {
        int xA = 1;
        int yA = 1;

        int xB = 10;
        int yB = 10;

        // 0초일때
        int sum = getBattery(xA, yA, xB, yB);

        // 1초에서 M초
        for (int i = 0; i < M; i++) {
            xA += dx[moveA[i]];
            yA += dy[moveA[i]];

            xB += dx[moveB[i]];
            yB += dy[moveB[i]];

            sum += getBattery(xA, yA, xB, yB);
        }
        return sum;

    }

    private static int getBattery(int xA, int yA, int xB, int yB) {
        int[][] batteries = new int[2][A];  // A(xA, yA)와 B(xB, yB)가 좌표에 있을 때 도달할 수 있는 BC의 배터리 저장

        for (int i = 0; i < A; i++) {
            batteries[0][i] = checkBC(xA, yA, i);  // A가 도달할 수 있는 거리인지 확인
        }

        for (int i = 0; i < A; i++) {
            batteries[1][i] = checkBC(xB, yB, i);  // B가 도달할 수 있는 거리인지 확인
        }

        int max = 0;  // 충전할 수 있는 배터리의 최대값
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                int sum = batteries[0][i] + batteries[1][j];

                if (i == j && batteries[0][i] == batteries[1][j])  // A와 B가 같은 BC를 사용할 때
                    sum /= 2;

                if (sum > max)
                    max = sum;
            }
        }

        return max;
    }

    private static int checkBC(int x, int y, int i) {
        BC bc = BCList.get(i);
        int distance = Math.abs(x - bc.x) + Math.abs(y - bc.y);

        if (distance <= bc.c)
            return bc.p; // 도달 가능
        return 0;  // 도달 불가능
    }
}
