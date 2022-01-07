package solution.programmars.Lv1;

public class Solution_Lv1_다트게임 {

    public int solution(String dartResult) {
        int answer = 0;

        int[] score = {0, 0, 0};
        int[] bonus = {1, 1, 1};
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c == '0') {
                if (score[idx] == 1)
                    score[idx] = 10;
            } else if (c >= '1' && c <= '9') {
                score[idx] = c - '0';
            }else if (c == 'S') {
                score[idx] = (int) Math.pow(score[idx], 1);
                idx++;
            } else if (c == 'D') {
                score[idx] = (int) Math.pow(score[idx], 2);
                idx++;
            } else if (c == 'T') {
                score[idx] = (int) Math.pow(score[idx], 3);
                idx++;
            } else if (c == '*') {
                bonus[idx - 1] *= 2;
                if (idx > 1) {
                    bonus[idx - 2] *= 2;
                }
            } else if (c == '#') {
                bonus[idx - 1] *= -1;
            }
        }

        for (int k = 0; k < 3; k++) {
            answer += (score[k] * bonus[k]);
        }
        return answer;
    }
}