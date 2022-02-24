package solution.programmars.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lv2_다리를지나는트럭 {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();  // 다리

        int sum_weight = 0, time = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (q.isEmpty()) {
                    q.offer(truck);
                    sum_weight += truck;
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum_weight -= q.poll();
                } else {
                    if (weight >= sum_weight + truck) {
                        q.offer(truck);
                        sum_weight += truck;
                        time++;
                        break;
                    } else {
                        q.offer(0);  // 전 트럭의 무게와 현재 트럭의 무게가 weight를 넘을 경우 다리 못건너고 대기, 큐는 무게가 0인 트럭이 건넌다고 가정
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}
