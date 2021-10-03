package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11401_이항계수3 {

    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long result = factorial(N) * ((power(factorial(N - K), mod - 2) * power(factorial(K), mod - 2)) % mod) % mod;
        System.out.println(result);
    }

    private static long factorial(int n) {
        long res = 1L;

        for (int i = 1; i <= n; i++) {
            res = res * i;
            res = res % mod;
        }
        return res;
    }

    private static long power(long x, long y) {
        long res = 1L;

        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % mod;

            x = (x * x) % mod;
            y = y >> 1;

        }
        return res;
    }
}
