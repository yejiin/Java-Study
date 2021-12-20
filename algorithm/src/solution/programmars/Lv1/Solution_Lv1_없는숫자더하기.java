package solution.programmars.Lv1;

public class Solution_Lv1_없는숫자더하기 {

    public int solution(int[] numbers) {
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += i;
        }

        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}
