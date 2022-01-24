package solution.programmars.Lv2;

import java.util.HashMap;
import java.util.Map;

public class Solution_Lv2_뉴스클러스터링 {

    public static void main(String[] args) {
        System.out.println(solution("handshake", "shake hands"));
    }
    public static int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        insertMap(map1, str1);
        insertMap(map2, str2);

        int i = countElIntersection(map1, map2);
        int u = countElUnion(map1, map2);

        double res = 1;
        if (u != 0)
            res = (double) i / u;
        return (int) (res * 65536);
    }

    private static int countElUnion(Map<String, Integer> map1, Map<String, Integer> map2) {
        int res = 0;

        Map<String, Integer> map = new HashMap<>();
        map.putAll(map1);

        for (String s : map2.keySet()) {
          map.put(s, Math.max(map1.getOrDefault(s, 0), map2.get(s)));
        }

        for (Integer v : map.values()) {
            res += v;
        }

        return res;
    }

    private static int countElIntersection(Map<String, Integer> map1, Map<String, Integer> map2) {
        int res = 0;

        for (String s : map1.keySet()) {
            res += Math.min(map1.get(s), map2.getOrDefault(s, 0));
        }

        return res;
    }

    private static void insertMap(Map<String, Integer> map, String str1) {

        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.charAt(i) + "" + str1.charAt(i + 1);
            str = str.toLowerCase();
            if (checkNotExistSpecialSymbol(str))
                map.put(str, map.getOrDefault(str, 0) + 1);
        }
    }

    private static boolean checkNotExistSpecialSymbol(String str) {
        if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z' && str.charAt(1) >= 'a' && str.charAt(1) <= 'z')
            return true;
        return false;
    }
}
