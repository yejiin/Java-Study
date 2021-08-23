package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기 {

    static int L, S;
    static char[] input;
    static char[] data;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        L = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        input = new char[S];
        data = new char[L];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < S; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        combination(0, 0);

    }

    private static void combination(int cnt, int start) {

        if (cnt == L) {
            if (check()) {
                for (int i = 0; i < L; i++) {
                    System.out.print(data[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < S; i++) {
            data[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }

    private static boolean check() {
        int numV = 0;
        int numC = 0;
        for (int i = 0; i < L; i++) {
            if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
                numV++;
            } else {
                numC++;
            }
        }
        if (numV >= 1 && numC >= 2) {
            return true;
        }
        return false;
    }

}
