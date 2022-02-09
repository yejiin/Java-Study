package solution.programmars.Lv2;

import java.util.HashSet;
import java.util.Set;

public class Solution_Lv2_소수찾기 {

    static boolean[] isSelected;
    static Character[] data;
    static Set<Integer> prime;

    public int solution(String numbers) {
        prime = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            isSelected = new boolean[numbers.length()];
            data = new Character[i];
            permutation(0, numbers, i);
        }
        return prime.size();
    }

    private static void permutation(int cnt, String numbers, int len) {
        if (cnt == len) {
            String result = "";
            for (int i = 0; i < data.length; i++) {
                result += data[i];
            }
            int num = Integer.parseInt(result);
            if (checkPrime(num)) {
                prime.add(num);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (isSelected[i])
                continue;

            data[cnt] = numbers.charAt(i);
            isSelected[i] = true;

            permutation(cnt + 1, numbers, len);
            isSelected[i] = false;
        }
    }

    private static boolean checkPrime(int num) {
        if (num == 0 || num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
