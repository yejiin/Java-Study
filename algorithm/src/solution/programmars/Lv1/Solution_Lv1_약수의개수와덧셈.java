package solution.programmars.Lv1;

public class Solution_Lv1_약수의개수와덧셈 {

    public static void main(String[] args) {
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        int cnt = 0;
        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    cnt++;
            }

            if (cnt % 2 == 0)
                answer += i;
            else
                answer -= i;
            cnt = 0;
        }
        return answer;
    }
}
