package solution.programmars.Lv2;

import java.util.Stack;

/**
 * 그리디 알고리즘
 */
public class Solution_Lv2_택배배달과수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> dStack = new Stack<>();
        Stack<Integer> pStack = new Stack<>();


        for (int i = 0; i < n; i++) {
            // 배달할 아이템 개수만큼 집의 위치를 스택에 저장
            for (int j = 0; j < deliveries[i]; j++) {
                dStack.push(i + 1);
            }

            // 수거할 아이템 개수만큼 집의 위치를 스택에 저장
            for (int j = 0; j < pickups[i]; j++) {
                pStack.push(i + 1);
            }
        }

        while(!dStack.isEmpty() && !pStack.isEmpty()) {
            int deliveryDistance = dStack.peek();
            int pickDistance = pStack.peek();

            for (int i = 0; i < cap; i++) {
                if (!dStack.isEmpty()) dStack.pop();
                if (!pStack.isEmpty()) pStack.pop();
            }

            answer += Math.max(deliveryDistance, pickDistance) * 2; // 배달 위치, 수거 위치 중 더 먼곳
        }

        while (!dStack.isEmpty()) {
            int distance = dStack.peek();
            for (int i = 0; i < cap; i++) {
                if (!dStack.isEmpty()) dStack.pop();
            }
            answer += distance * 2;
        }

        while (!pStack.isEmpty()) {
            int distance = pStack.peek();
            for (int i = 0; i < cap; i++) {
                if (!pStack.isEmpty()) pStack.pop();
            }
            answer += distance * 2;
        }

        return answer;
    }
}
