package solution.programmars.Lv2;

public class Solution_Lv2_피보나치수 {
    private static int[] memo = new int[100001];

    public int solution(int n) {
        return fibo(n) % 1234567;
    }

    public static int fibo(int k) {
        if (memo[k] == 0) {
            if (k <= 2) {
                memo[k] = 1;
            } else {
                memo[k] = (fibo(k - 1) + fibo(k - 2)) % 1234567;
            }
        }
        return memo[k];
    }
}