package solution.programmars.Lv2;

import java.util.*;

public class Solution_Lv2_단체사진찍기 {

    static int result;
    static boolean[] isSelected;
    static String[] order;
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public int solution(int n, String[] data) {
        result = 0;
        isSelected = new boolean[8];
        order = new String[8];

        permutation(0, data, n);

        return result;
    }

    static void permutation(int cnt, String[] data, int n) {
        if (cnt == 8) {

            if (checkCondition(data, n))
                result++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (isSelected[i])
                continue;

            order[cnt] = friends[i];
            isSelected[i] = true;
            permutation(cnt + 1, data, n);
            isSelected[i] = false;
        }
    }

    static boolean checkCondition(String[] data, int n) {

        HashMap<String, Integer> map = new HashMap<>();  // map에 인덱스 저장

        for (int i = 0; i < 8; i++) {
            map.put(order[i], i);
        }

        for (int i = 0; i < n; i++) {

            int num1 = map.get(String.valueOf(data[i].charAt(0)));
            int num2 = map.get(String.valueOf(data[i].charAt(2)));

            if (data[i].charAt(3) == '=') {
                if (Math.abs(num1 - num2 )- 1 != data[i].charAt(4) -'0')
                    return false;

            } else if (data[i].charAt(3) == '<') {
                if (Math.abs(num1 - num2 ) - 1 >= data[i].charAt(4) -'0')
                    return false;
            } else {
                if (Math.abs(num1 - num2 ) - 1 <= data[i].charAt(4) -'0')
                    return false;
            }

        }

        return true;
    }
}
