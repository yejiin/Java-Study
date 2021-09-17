package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열 {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            int[] arr = new int[N];
            int[] LIS = new int[N];

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int size = 0;
            for (int i = 0; i < N; i++) {
                int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i])) - 1;
                LIS[temp] = arr[i];

                if (temp == size)
                    ++size;
            }
            sb.append("#").append(tc).append(" ").append(size).append("\n");
        }
        System.out.println(sb);
    }

}
