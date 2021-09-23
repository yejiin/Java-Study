package solution.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_1786_찾기 {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        char[] T = in.readLine().toCharArray();
        char[] P = in.readLine().toCharArray();

        int n = T.length;
        int m = P.length;

        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && P[i] != P[j]) {
                j = pi[j - 1];
            }
            if (P[i] == P[j])
                pi[i] = ++j;
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && T[i] != P[j])
                j = pi[j - 1];

            if (T[i] == P[j]) {
                if (j == m - 1) {
                    cnt++;
                    list.add((i + 2) - m);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        System.out.println(cnt);
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++)
                System.out.print(list.get(i) + " ");
        }

    }
}
