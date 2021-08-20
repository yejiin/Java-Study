package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2961_도영이가만든맛있는음식 {

    static int N;
    static int[][] flavors;
    static boolean[] isSelected;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        flavors = new int[N][2];
        isSelected = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            flavors[i] = new int[] {sour, bitter};
        }

        subset(0);
        System.out.println(result);
    }

    private static void subset(int cnt) {
        if (cnt == N) {
            boolean flag = false;
            for (boolean i : isSelected) {
                if (i == true) flag = true;
            }
            if(flag) calcFlavor();
             return;
        }

        isSelected[cnt] = true;
        subset(cnt + 1);
        isSelected[cnt] = false;
        subset(cnt + 1);
    }

    private static void calcFlavor() {
        int calcSour = 1;
        int calcBitter = 0;
        for (int i = 0; i<N; i++) {
            if (isSelected[i]) {
                calcSour *= flavors[i][0];
                calcBitter += flavors[i][1];
            }
        }
        result = Math.min(result, Math.abs(calcSour - calcBitter));
    }
}
