package solution.programmars.Lv2;

import java.util.*;

public class Solution_Lv2_메뉴리뉴얼 {

    static int orderLen;
    static boolean[] isSelected;
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();

        for (String order : orders) {
            orderLen = order.length();
            isSelected = new boolean[orderLen];
            subset(0, order, course);
        }

        List<String>[] order = new ArrayList[11];
        int[] max = new int[11];


        for (int i = 0; i < 11; i++) {
            order[i] = new ArrayList<>();
        }

        for (String s : map.keySet()) {
            int cnt = map.get(s);
            if (cnt <= 1)
                continue;
            if (max[s.length()] < cnt) {
                max[s.length()] = cnt;
                order[s.length()].clear();
                order[s.length()].add(s);
            } else if (max[s.length()] == cnt) {
                order[s.length()].add(s);
            }
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < order[i].size(); j++) {
                answer.add(order[i].get(j));
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }


    private static void subset(int cnt, String order, int[] course) {

        if (cnt == orderLen) {
            if (checkOrderCount(course)) {
                List<Character> list = new ArrayList<>();

                for (int i = 0; i < orderLen; i++) {
                    if (isSelected[i] == true)
                        list.add(order.charAt(i));
                }

                Collections.sort(list);
                String str = "";
                for (int i = 0; i < list.size(); i++) {
                    str += list.get(i);
                }
                map.put(str, map.getOrDefault(str, 0) + 1);

            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt + 1, order, course);
        isSelected[cnt] = false;
        subset(cnt + 1, order, course);
    }

    private static boolean checkOrderCount(int[] course) {

        int count = 0;
        for (boolean s : isSelected) {
            count += s == true ? 1 : 0;
        }

        for (int c : course) {
            if (count == c)
                return true;
        }
        return false;
    }
}
