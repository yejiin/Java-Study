package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1931_회의실배정 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());

        PriorityQueue<Conference> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            q.add(new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int count = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            Conference cur = q.poll();
            if (cur.stime >= endTime) {
                count++;
                endTime = cur.etime;
            }
        }
        System.out.println(count);
    }

    static class Conference implements Comparable<Conference> {
        int stime, etime;

        public Conference(int stime, int etime) {
            this.stime = stime;
            this.etime = etime;
        }

        @Override
        public int compareTo(Conference o) {
            if (this.etime == o.etime)
                return Integer.compare(this.stime, o.stime);
            return Integer.compare(this.etime, o.etime);
        }
    }
}
