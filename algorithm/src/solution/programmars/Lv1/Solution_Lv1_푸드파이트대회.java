package solution.programmars.Lv1;

public class Solution_Lv1_푸드파이트대회 {

    public String solution(int[] food) {
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < food.length; i++) {
            int num = food[i];
            for (int j = 0; j < (num / 2); j++) {
                sb.append(i);
            }
        }
        String answer = sb.toString();
        String reverse = sb.reverse().toString();

        return answer + "0" + reverse;
    }

    /* 다른 풀이 방식
    public String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }

        return answer;
    }
     */
}
