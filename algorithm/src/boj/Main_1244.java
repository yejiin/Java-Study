package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {

    private static int switchCnt;
    private static int[] switchs;

    public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        switchCnt = Integer.parseInt(in.readLine());
        switchs = new int[switchCnt + 1];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        for (int i = 0; i < switchCnt; i++) {
            switchs[i + 1] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(in.readLine());

        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            modifySwitch(gender, num);
        }

        for (int i = 1; i <= switchCnt; i++) {
            System.out.print(switchs[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }

        }
    }

    private static void modifySwitch(int gender, int num) {
        if (gender == 1) {
            for (int j = 1; j <= switchCnt; j++) {
                if (j % num == 0)
                    switchs[j] = switchs[j] == 1 ? 0 : 1;
            }
        } else if (gender == 2) {
            int left = num - 1;
            int mid = num;
            int right = num + 1;

            switchs[mid] = switchs[mid] == 1 ? 0 : 1;

            while (true) {
                if (left <= 0) {
                    return;
                }

                if (right > switchCnt) {
                    return;
                }

                if (switchs[left] == switchs[right]) {
                    switchs[left] = switchs[left] == 1 ? 0 : 1;
                    switchs[right] = switchs[right] == 1 ? 0 : 1;
                } else {
                    return;
                }

                left--;
                right++;
            }
        }

    }
}