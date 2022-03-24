package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20055_컨베이어벨트위의로봇 {

    static int N, K;
    static Belt[] conveyerBelt;
    static int KCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        conveyerBelt = new Belt[2 * N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 2 * N; i++)
            conveyerBelt[i] = new Belt(Integer.parseInt(st.nextToken()), false);

        int phase = 0;
        while (true) {
            phase++;

            rotate();  // 컨베이어 벨트 회전
            moveRobot();  // 로봇 이동
            liftRobot();

            if (KCnt >= K)
                break;
        }

        System.out.println(phase);
    }

    private static void rotate() {
        // 로봇 내림
        conveyerBelt[N - 1].isRobot = false;

        Belt liftBelt = conveyerBelt[(2 * N) - 1];

        for (int i = 2 * N - 1; i > 0; i--)
            conveyerBelt[i] = conveyerBelt[i - 1];

        conveyerBelt[0] = liftBelt;
    }

    private static void moveRobot() {

        // 마지막 벨트 로봇 내리기
        conveyerBelt[N - 1].isRobot = false;

        for (int i = N - 2; i >= 0; i--) {
            Belt curBelt = conveyerBelt[i];
            Belt nextBelt = conveyerBelt[i + 1];

            if (!curBelt.isRobot)
                continue;

            // 옆칸으로 이동 가능하면
            if (!nextBelt.isRobot && nextBelt.durability >= 1) {
                nextBelt.isRobot = true;
                nextBelt.durability -= 1;
                curBelt.isRobot = false;

                if (nextBelt.durability == 0)
                    KCnt++;
            }
        }
    }

    private static void liftRobot() {
        Belt firstBelt = conveyerBelt[0];
        if (firstBelt.durability >= 1) {
            firstBelt.isRobot = true;
            firstBelt.durability -= 1;

            if (firstBelt.durability == 0)
                KCnt++;
        }
    }

    static class Belt {
        int durability;
        boolean isRobot;

        public Belt(int durability, boolean isRobot) {
            this.durability = durability;
            this.isRobot = isRobot;
        }
    }
}
