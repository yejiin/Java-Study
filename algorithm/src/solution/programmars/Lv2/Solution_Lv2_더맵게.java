package solution.programmars.Lv2;

import java.util.PriorityQueue;

public class Solution_Lv2_더맵게 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {0, 0, 0, 0, 0}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            q.offer(scoville[i]);
        }

        while(q.size() >= 2) {
            Integer cur = q.poll();

            if (cur >= K)
                break;

            Integer next = q.poll();
            q.add(cur + (next * 2));
            answer++;
        }

        if (!q.isEmpty()) {
            Integer s = q.poll();
            if (s < K)
                return -1;
        }
        return answer;
    }
}
