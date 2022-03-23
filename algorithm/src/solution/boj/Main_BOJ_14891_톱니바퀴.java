package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_14891_톱니바퀴 {

    static List<Integer>[] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        gears = new List[4];
        for (int i = 0; i < 4; i++)
            gears[i] = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            String str = in.readLine();
            for (int j = 0; j < 8; j++)
                gears[i].add(str.charAt(j) - '0');
        }

        int K = Integer.parseInt(in.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            // 회전시킬 톱니바퀴 찾기
            List<int[]> rotateGear = findRotate(num, dir);
            // 톱니바퀴 회전
            rotate(rotateGear);
        }

        System.out.println(score());
    }

    private static List<int[]> findRotate(int num, int dir) {
        List<int[]> rotateGears = new ArrayList<>();
        rotateGears.add(new int[]{num, dir});

        // 왼쪽에 있는 톱니바퀴 회전
        int ld = dir;
        for (int j = num - 1; j >= 0; j--) {
            ld *= -1;
            if (gears[j].get(2) != gears[j + 1].get(6)) {
                rotateGears.add(new int[]{j, ld});
            } else break;
        }

        // 오른쪽에 있는 톱니바퀴 회전
        int rd = dir;
        for (int j = num + 1; j < 4; j++) {
            rd *= -1;
            if (gears[j - 1].get(2) != gears[j].get(6)) {
                rotateGears.add(new int[]{j, rd});
            }  else break;
        }
        return rotateGears;
    }

    private static void rotate(List<int[]> rotateGears) {
        for (int[] rotateGear : rotateGears) {
            // 시계방향 일 때
            if (rotateGear[1] == 1) {
                // 맨 뒤 삭제, 맨 앞 추가
                int n = gears[rotateGear[0]].get(7);
                gears[rotateGear[0]].remove(7);
                gears[rotateGear[0]].add(0, n);
            } else {
                // 맨 앞 삭제, 맨 뒤 추가
                int n = gears[rotateGear[0]].get(0);
                gears[rotateGear[0]].remove(0);
                gears[rotateGear[0]].add(n);
            }
        }
    }

    private static int score() {
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            if (gears[i].get(0) == 1)
                cnt += Math.pow(2, i);
        }
        return cnt;
    }
}
