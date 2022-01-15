package solution.programmars.Lv2;

public class Solution_Lv2_멀쩡한사각형 {

    public long solution(int w, int h) {
        long answer = 0;

        long min = (w < h) ? w : h;
        long gcd = 0;
        for (long i = 1; i <= min; i++) {
            if (w % i == 0 && h % i == 0)
                gcd = i;
        }
        answer = ((long) w * h) - ((w / gcd) + (h / gcd) - 1) * gcd;

        return answer;
    }
}
