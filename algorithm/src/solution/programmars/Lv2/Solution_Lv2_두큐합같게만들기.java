package solution.programmars.Lv2;

import java.util.*;

public class Solution_Lv2_두큐합같게만들기 {

    public int solution(int[] queue1, int[] queue2) {
        int length = queue1.length;

        List<Integer> queue1Arr = new ArrayList<>();
        List<Integer> queue2Arr = new ArrayList<>();
        long queue1Sum = 0;
        long queue2Sum = 0;
        for(int i = 0; i < length; i++) {
            queue1Arr.add(queue1[i]);
            queue1Sum += queue1[i];

            queue2Arr.add(queue2[i]);
            queue2Sum += queue2[i];
        }

        if ((queue1Sum + queue2Sum) % 2 == 1) {
            return - 1;
        }

        int idx1 = 0;
        int idx2 = 0;
        int cnt;
        for (cnt= 0; cnt < length * 3; cnt++) {  // 실패가 되지 않는 범위(하드코딩)
            if (queue1Sum < queue2Sum) {
                int num = queue2Arr.get(idx2++);
                queue1Sum += num;
                queue2Sum -= num;
                queue1Arr.add(num);
            } else if (queue1Sum > queue2Sum) {
                int num = queue1Arr.get(idx1++);
                queue2Sum += num;
                queue1Sum -= num;
                queue2Arr.add(num);
            } else {
                return cnt;
            }

            if (idx1 >= queue1Arr.size() || idx2 >= queue2Arr.size()) {
                break;
            }
        }
        return -1;
    }
}
