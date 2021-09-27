package solution.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1755_숫자놀이 {

    static class Num implements Comparable<Num> {
        String str;
        int num;

        public Num(String str, int num) {
            super();
            this.str = str;
            this.num = num;
        }

        @Override
        public int compareTo(Num o) {
            return this.str.compareTo(o.str);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


        st = new StringTokenizer(in.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Num[] list = new Num[N - M + 1];

        int n = 0;
        for (int i = M; i <= N; i++) {
            if (i < 10) {
                list[n++] = new Num(number[i], i);
            }
            else {
                String str = "";
                str += number[i/10];
                str += " ";
                str += number[i%10];
                list[n++] = new Num(str, i);
            }
        }

        Arrays.sort(list);

        int c = 0;
        for (Num num : list) {
            if (c == 10) {
                c = 0;
                System.out.println();
            }
            System.out.print(num.num + " ");
            c++;
        }
    }
}
