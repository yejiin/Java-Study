package solution.programmars.Lv1;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_Lv1_완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();

        for (String p : participant) {
            if (!hash.containsKey(p))
                hash.put(p, 1);
            else
                hash.put(p, hash.get(p) + 1);
        }

        for (String c : completion) {
            if (hash.get(c) == 1)
                hash.remove(c);
            else
                hash.put(c, hash.get(c) - 1);
        }
        return hash.keySet().stream().collect(Collectors.toList()).get(0);
    }
}
