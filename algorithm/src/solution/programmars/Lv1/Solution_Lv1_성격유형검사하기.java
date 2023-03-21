package solution.programmars.Lv1;

import java.util.*;

class Solution_Lv1_성격유형검사하기 {

    static char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

    public String solution(String[] survey, int[] choices) {
         Map<Character, Integer> typeMap = new HashMap() {{
             put('R', 0);
             put('T', 0);
             put('C', 0);
             put('F', 0);
             put('J', 0);
             put('M', 0);
             put('A', 0);
             put('N', 0);
         }};

        for(int i = 0; i < survey.length; i++) {
            Character type = survey[i].charAt(getOrder(choices[i]));
            typeMap.put(type, typeMap.getOrDefault(type, 0)  + getScore(choices[i]));
        }

        return getType(typeMap);
    }

    private static String getType(Map<Character, Integer> typeMap) {
        String result = "";

        for (int i = 0; i < 4; i++) {
            int idx = i * 2;
            if (typeMap.get(types[idx]) >= typeMap.get(types[idx + 1])) {
                result += types[idx];
            } else if (typeMap.get(types[idx]) < typeMap.get(types[idx + 1])) {
                result += types[idx + 1];
            }
        }
        return result;
    }

    private static int getOrder(int choice) {
        List<Integer> first = List.of(1, 2, 3);

        if (first.contains(choice)) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int getScore(int choice) {
        List<Integer> one = List.of(3, 5);
        List<Integer> two = List.of(2, 6);
        List<Integer> three = List.of(1, 7);

        if (one.contains(choice)) {
            return 1;
        } else if (two.contains(choice)) {
            return 2;
        } else if (three.contains(choice)) {
            return 3;
        }
        return 0;
    }
}