package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13458_시험감독 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(in.readLine());

        int[] candidates = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long sum = 0;
        for (int candidate : candidates) {
            if (candidate > B) {
                sum += Math.ceil((double)(candidate - B) / C);
            }
        }

        sum += N;

        System.out.println(sum);
    }
}
