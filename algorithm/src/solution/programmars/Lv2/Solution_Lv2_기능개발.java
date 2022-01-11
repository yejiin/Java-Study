package solution.programmars.Lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lv2_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();

        int num = 0;
        for (int i = 0; i < progresses.length; i++) {
            q.offer(new int[] {progresses[i], speeds[i], ++num});
        }

        int progress = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.println(cur[0] + " " + cur[1] + " " +cur[2]);

            if (cur[0] >= 100) {
                if (progress < cur[2]) {
                    cur[0] = cur[0] + cur[1];
                    q.offer(cur);
                } else {
                    progress++;
                    cnt++;
                }
            } else {
                if (cnt > 0) {
                    answerList.add(cnt);
                    cnt = 0;
                }
                    cur[0] = cur[0] + cur[1];
                    q.offer(cur);
            }
        }
        answerList.add(cnt);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
           answer[i] = answerList.get(i);
        }
        return answer;
    }
}