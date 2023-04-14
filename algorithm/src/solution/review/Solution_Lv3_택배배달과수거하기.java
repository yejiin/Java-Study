package solution.review;

import java.util.*;

public class Solution_Lv3_택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();

        // stack 세팅
        for (int i = 0; i < n; i++) {
            int d = deliveries[i];
            for (int j = 0; j < d; j++) {
                dStack.add(i + 1);
            }

            int p = pickups[i];
            for (int j = 0; j < p; j++) {
                pStack.add(i + 1);
            }
        }

        while (!dStack.isEmpty() && !pStack.isEmpty()) {
            int dDistance = dStack.peek();
            int pDistance = pStack.peek();

            // 배달 갯수와 픽업 갯수를 신경 쓰지 않아도 되는 이유는
            // 집에 왔다가 오는 길에 cap 만큼을 가지고 있는 것을 조절이 가능하기 때문이다.
            // 따라서 stack에서 cap만큼의 값을 빼내는 것만 신경써도 된다.
            for (int i = 0; i < cap; i++) {
                if (!dStack.isEmpty()) {
                    dStack.pop();
                }
                if (!pStack.isEmpty()) {
                    pStack.pop();
                }
            }

            answer += Math.max(dDistance, pDistance) * 2;
        }

        while (!dStack.isEmpty()) {
            int dDistance = dStack.peek();
            for (int i = 0; i < cap; i++) {
                if (!dStack.isEmpty()) {
                    dStack.pop();
                }
            }
            answer += (dDistance * 2);
        }

        while (!pStack.isEmpty()) {
            int pDistance = pStack.peek();
            for (int i = 0; i < cap; i++) {
                if (!pStack.isEmpty()) {
                    pStack.pop();
                }
            }
            answer += (pDistance * 2);
        }

        return answer;
    }
}
