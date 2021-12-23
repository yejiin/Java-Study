package solution.programmars.Lv1;

// 에라토스테네스의 체
public class Solution_Lv1_소수찾기 {

    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int answer = 0;
        boolean[] noPrime = new boolean[n + 1];

        noPrime[0] = true;
        noPrime[1] = true;

        for (int i = 0; i <= Math.sqrt(n); i++) {

            if (noPrime[i])  // 이미 체크된 배열이면 continue
                continue;

            // i는 소수, i의 배수는 소수가 아님
            for (int j = i * 2; j <= n; j += i) {
                noPrime[j] = true;
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!noPrime[i])
                answer++;
        }
        return answer;
    }
}
