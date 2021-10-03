package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11050_이항계수1 {


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = factorial(N) / (factorial(N - K) * factorial(K));
        System.out.println(result);
    }

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

}
