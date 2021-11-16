package solution.programmars.Lv1;

public class Solution_Lv1_부족한금액계산하기 {

    public long solution(int price, int money, int count) {
        long answer = money;
        for (int i = 1; i <= count; i++) {
            answer -= price * i;
        }
        return answer > 0 ? 0 : -answer;
    }
}
