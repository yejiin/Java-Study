package solution.programmars.Lv1;

public class Solution_Lv1_3진법뒤집기 {
    public int solution(int n) {
        String ternaryStr = "";

        while(n != 0) {
            int remainder = n % 3;
            n /= 3;
            ternaryStr += remainder;
        }

        long ternaryInt = Long.valueOf(ternaryStr);

        int answer = 0;
        int num = 0;
        while (ternaryInt != 0) {
            long r = ternaryInt % 10;
            answer += r * Math.pow(3, num++);
            ternaryInt /= 10;
        }

        return answer;
//        return Integer.parseInt(ternaryStr, 3); // 3진법 문자열에서 10진법으로 변환
    }
}
