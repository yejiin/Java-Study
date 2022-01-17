package solution.programmars.Lv2;

public class Solution_Lv2_124나라의숫자 {

    public String solution(int n) {
        StringBuffer answer = new StringBuffer();

        int num = n;
        int quotient = 0;
        int remainder = 0;

        while (true) {
            quotient = num / 3;
            remainder = num % 3;

            if (remainder == 0) {
                quotient -= 1;
                remainder = 4;
            }

            answer = answer.insert(0, remainder);
            num = quotient;
            if (quotient == 0)
                break;
        }
        return answer.toString();
    }
}
