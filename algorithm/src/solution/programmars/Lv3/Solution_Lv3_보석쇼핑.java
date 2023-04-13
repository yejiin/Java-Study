package solution.programmars.Lv3;

import java.util.*;

public class Solution_Lv3_보석쇼핑 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
    }

    public static int[] solution(String[] gems) {
        Map<String, Integer> gemMap = new HashMap<>();
        int startIdx = 0;
        int endIdx = gems.length + 1;

        // map 초기화
        for (int i = 0; i < gems.length; i++) {
            if (!gemMap.containsKey(gems[i])) {
                gemMap.put(gems[i], 0);
            }
        }

        // 슬라이딩 윈도우
        int eIdx = 0;
        int count = 0;
        for (int sIdx = 0; sIdx < gems.length - gemMap.size() + 1; sIdx++) {
            for (; eIdx < gems.length; eIdx++) {
                String gem = gems[eIdx];
                if (gemMap.get(gem) == 0) {
                    count++;
                    gemMap.put(gem, 1);
                } else {
                    gemMap.put(gem, gemMap.get(gem) + 1);
                }

                if (count == gemMap.size()) {
                    break;
                }
            }

            if (eIdx - sIdx < endIdx - startIdx && count == gemMap.size()) {
                startIdx = sIdx;
                endIdx = eIdx;
            }

            if (gemMap.size() == eIdx - sIdx + 1) {
                break;
            }

            int c = gemMap.get(gems[sIdx]) - 1;
            if (c == 0) {
                count--;
            }
            gemMap.put(gems[sIdx], c);
            System.out.println(sIdx);
            System.out.println("getMap = " + gemMap);
        }
        return new int[]{startIdx + 1, endIdx + 1};
    }
}
