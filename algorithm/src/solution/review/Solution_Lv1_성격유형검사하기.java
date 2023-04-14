package solution.review;

import java.util.*;

public class Solution_Lv1_성격유형검사하기 {
    static String[] TYPE = {"R", "T", "C", "F", "J", "M", "A", "N"};
    static int[] SCORE = {0, 3, 2, 1, 0, 1, 2, 3};

    static Map<String, Integer> scoreMap;

    static {
        scoreMap = new HashMap<>();
        scoreMap.put("R", 0);
        scoreMap.put("T", 0);
        scoreMap.put("C", 0);
        scoreMap.put("F", 0);
        scoreMap.put("J", 0);
        scoreMap.put("M", 0);
        scoreMap.put("A", 0);
        scoreMap.put("N", 0);
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            int score = choices[i];

            String t;
            if (score > 4) {
                t = String.valueOf(type.charAt(1));
                scoreMap.put(t, scoreMap.get(t) + SCORE[score]);
            } else {
                t = String.valueOf(type.charAt(0));
                scoreMap.put(t, scoreMap.get(t) + SCORE[score]);
            }
        }

        for (int i = 0; i < TYPE.length / 2; i++) {
            int idx = i * 2;
            if (scoreMap.get(TYPE[idx]) >= scoreMap.get(TYPE[idx + 1])) {
                answer += TYPE[idx];
            } else {
                answer += TYPE[idx + 1];
            }
        }

        return answer;
    }
}