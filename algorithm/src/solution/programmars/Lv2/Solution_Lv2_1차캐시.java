package solution.programmars.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lv2_1차캐시 {

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> cache = new LinkedList<>();

        for (String c : cities) {
            String city = c.toLowerCase();
            if (cache.contains(city)) {
                cache.remove(city);
                cache.offer(city);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.poll();
                }

                if (cache.size() < cacheSize) {
                    cache.offer(city);
                }

                answer += 5;
            }
        }

        return answer;
    }
}
