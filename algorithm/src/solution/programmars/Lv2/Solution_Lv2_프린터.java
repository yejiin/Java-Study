package solution.programmars;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lv2_프린터 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(i);
        }

        int num = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int curPriority = priorities[cur];

            boolean flag = false;  // 자신보다 중요도 높은 것이 있는지 확인
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] > curPriority)
                    flag = true;
            }

            if (flag) {
                q.offer(cur);
            } else {
                if (location == cur) {
                    answer = num;
                    break;
                }

                priorities[cur] = 0;
                num++;
            }
        }
        
        return answer;
    }
}
