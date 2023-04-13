package solution.programmars.Lv3;

import java.util.*;

public class Solution_Lv3_입국심사 {

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;  // 최소 시간
        long right = (long) n * times[times.length - 1];  // 최대 시간
        while (left <= right) {
            long mid = (left + right) / 2;  // 임시로 완료될 것 같은 시간을 정함
            long sum = 0;  // 총 심사한 인원

            for (int i = 0; i < times.length; i++) {  // 빨리 심사하는 심사관 순으로 심사 처리
                sum += mid / times[i];
            }

            if (sum < n) {  // 해야할 인원보다 심사처리 못할 경우 -> 시간 더 필요 (mid 시간을 늘려줌)
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
