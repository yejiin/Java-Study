package recursion;

public class FactorialTest {

    private static int factorial0(int n) {
        int res = 1;
        for (int i = n; i > 0; i--) {
            res *= i;
        }
        return res;
    }

    // 반복문 그대로 재귀적으로 변경
    private static int res = 1;

    private static void factorial0_2(int i) {

        if (i == 0)
            return;
        res *= i;
        factorial0_2(i - 1);
    }

    private static int factorial(int n) {

        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial0(5));
        factorial0_2(5);
        System.out.println(res);
        System.out.println(factorial(5));
    }
}
