package solution.programmars.Lv2;

import java.util.HashSet;
import java.util.Set;

public class Solution_Lv2_영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        Set<String> usedWords = new HashSet<>();
        boolean flag = false;
        String preWord = "";
        int order = -1;

        for (String word : words) {

            if (usedWords.contains(word) || (!preWord.equals("") && !preWord.endsWith(word.substring(0, 1)))) {
                order++;
                flag = true;
                break;
            }

            order++;
            preWord = word;
            usedWords.add(word);
        }

        if (flag) {
            answer[0] = (order % n) + 1;
            answer[1] = (order / n) + 1;
        }

        return answer;
    }
}
