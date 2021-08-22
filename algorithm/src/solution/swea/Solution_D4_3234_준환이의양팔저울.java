package solution.swea;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {

    static int N;
    static int[] weights;

    static int[] data;
    static boolean[] isSelectedP;
    static boolean[] isSelectedS;

    static int count;

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            weights = new int[N];
            data = new int[N];
            isSelectedP = new boolean[N];
            isSelectedS = new boolean[N];
            count = 0;

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            permutation(0);
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(int cnt) {

        if (cnt == N) {
            subset(0, 0, 0);
            return;
        }

        for (int i = 0; i < N; i++) {

            if (isSelectedP[i])
                continue;

            data[cnt] = weights[i];
            isSelectedP[i] = true;
            permutation(cnt + 1);
            isSelectedP[i] = false;

        }
    }

    private static void subset(int cnt, int sumR, int sumL) {

        if (sumR > sumL)
            return;

        if (cnt == N) {
            count++;
            return;
        }

        isSelectedS[cnt] = true;
        subset(cnt + 1, sumR + data[cnt], sumL);
        isSelectedS[cnt] = false;
        subset(cnt + 1, sumR, sumL + data[cnt]);
    }
}
