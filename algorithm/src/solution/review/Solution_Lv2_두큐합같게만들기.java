package solution.review;

import java.util.*;

public class Solution_Lv2_두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);

            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }

        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }

        int answer = 0;
        for (; answer < queue1.length * 3; answer++) {
            if (sum1 == sum2) {
                return answer;
            } else if (sum1 > sum2) {
                int num = q1.poll();
                q2.offer(num);
                sum1 -= num;
                sum2 += num;
            } else {
                int num = q2.poll();
                q1.offer(num);
                sum2 -= num;
                sum1 += num;
            }
        }
        return -1;
    }
}
