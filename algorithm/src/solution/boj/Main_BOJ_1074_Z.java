package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z {

    static int counter = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        subSquare((int) Math.pow(2, N), r, c);

        System.out.println(counter);
    }

    static void subSquare(int width, int r, int c) {

        if (r == 0 && c == 0) {
            return;
        }

        int pow = (int) Math.pow(width / 2, 2);

        if (r < width / 2 && c < width / 2) {
            counter += 0;
            subSquare(width / 2, r, c);
        } else if (r < width / 2 && c < width) {
            counter += pow * 1;
            subSquare(width / 2, r, c - (width / 2));
        } else if (r < width && c < width / 2) {
            counter += pow * 2;
            subSquare(width, r - (width / 2), c);
        } else {
            counter += pow * 3;
            subSquare(width, r - (width / 2), c - (width / 2));
        }

    }

}
