package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2309_일곱난쟁이 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[] nineDwarfs = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            nineDwarfs[i] = Integer.parseInt(in.readLine());
            sum += nineDwarfs[i];
        }

        Arrays.sort(nineDwarfs);

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (nineDwarfs[i] + nineDwarfs[j]) == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(nineDwarfs[k]);
                    }
                    return;
                }
            }
        }
    }
}
