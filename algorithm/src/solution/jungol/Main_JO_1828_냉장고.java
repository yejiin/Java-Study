package solution.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());

        Temporary[] temporaries = new Temporary[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            temporaries[i] = new Temporary(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(temporaries);

        int count = 1;
        int highestTemp = temporaries[0].highest;
        for (int i = 1; i < N; i++) {
            if (temporaries[i].lowest > highestTemp) {
                count++;
                highestTemp = temporaries[i].highest;
            }
        }

        System.out.println(count);

    }

    static class Temporary implements Comparable<Temporary> {
        int lowest, highest;

        public Temporary(int lowest, int highest) {
            super();
            this.lowest = lowest;
            this.highest = highest;
        }

        @Override
        public int compareTo(Temporary o) {
            return this.highest - o.highest;
        }

    }

}
