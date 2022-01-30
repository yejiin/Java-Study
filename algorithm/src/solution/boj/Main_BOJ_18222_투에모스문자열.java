package solution.boj;

import java.util.Scanner;

public class Main_BOJ_18222_투에모스문자열 {

    static long[] arr;  // 문자열이 결정된 길이

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();

        arr = new long[61];  // 2^60 = 10^18
        arr[0] = 1;
        for (int i = 1; i < 61; i++) {
            arr[i] = arr[i - 1] * 2;
        }

        System.out.println(getNum(k));
    }

    private static int getNum(long x) {
        if (x == 1) return 0;

        for (int i = 0; i < 61; i++) {
            if (arr[i] >= x)
                return 1 - getNum(x - arr[i - 1]);  // 0을 1로, 1을 0으로
        }
        return 0;
    }
}
