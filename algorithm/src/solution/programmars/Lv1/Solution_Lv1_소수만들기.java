package solution.programmars.Lv1;

public class Solution_Lv1_소수만들기 {

    static int N;
    static int[] numbers;
    static int answer;

    public static int solution(int[] nums) {
        answer = 0;

        N = nums.length;
        numbers = new int[3];

        combination(0, 0, nums);

        return answer;
    }

    private static void combination(int cnt, int start, int[] nums) {
        if (cnt == 3) {
            int n = 0;
            for (int i = 0; i < 3; i++) {
                n += numbers[i];
            }
            if (isPrime(n)) {
                answer += 1;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = nums[i];
            combination(cnt + 1, i + 1, nums);
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
