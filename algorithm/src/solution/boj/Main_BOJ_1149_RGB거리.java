package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());

        int[][] D = new int[N][3];

        st = new StringTokenizer(in.readLine(), " ");
        D[0][0] = Integer.parseInt(st.nextToken());
        D[0][1] = Integer.parseInt(st.nextToken());
        D[0][2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            D[i][0] = r + Math.min(D[i - 1][1], D[i - 1][2]);
            D[i][1] = g + Math.min(D[i - 1][0], D[i - 1][2]);
            D[i][2] = b + Math.min(D[i - 1][0], D[i - 1][1]);

        }

        // steam을 이용한 배열의 최솟값 구하기
        System.out.println(Arrays.stream(D[N - 1]).min().getAsInt());
    }

}
