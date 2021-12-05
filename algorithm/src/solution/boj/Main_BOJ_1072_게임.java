package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1072_게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = getPercentage(X, Y);

        int result = -1;
        int left = 0;
        int right = (int) 1e9;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (getPercentage(X + mid, Y + mid) != Z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);

    }

    private static int getPercentage(int x, int y) {

        return (int) ((long) y * 100 / x);
    }
}
