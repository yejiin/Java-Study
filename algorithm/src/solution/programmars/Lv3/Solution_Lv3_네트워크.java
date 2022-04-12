package solution.programmars.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lv3_네트워크 {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
    public static int solution(int n, int[][] computers) {
        boolean[] networks = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!networks[i]) {
                connect(i, networks, n, computers);
                answer++;
            }
        }

        return answer;
    }

    private static void connect(int x, boolean[] networks, int n, int[][] computers) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        networks[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < n; i++) {
                if (computers[cur][i] == 1 && cur != i && !networks[i]) {
                    q.offer(i);
                    networks[i] = true;
                }
            }
        }
    }
}
