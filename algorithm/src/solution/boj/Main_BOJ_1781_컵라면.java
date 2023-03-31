package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1781_컵라면 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(in.readLine());

        List<Problem> problemList = new ArrayList<>();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(in.readLine());
            problemList.add(new Problem(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(problemList);

        PriorityQueue<Integer> ramenPq = new PriorityQueue<>(); //
        for (Problem problem : problemList) {
            if (ramenPq.size() < problem.deadLine) {
                ramenPq.add(problem.ramenCnt);
            } else if (ramenPq.size() == problem.deadLine) {
                if (ramenPq.peek() < problem.ramenCnt) {
                    ramenPq.poll();
                    ramenPq.offer(problem.ramenCnt);
                }
            }
        }

        int result = 0;
        while (!ramenPq.isEmpty()) {
            result += ramenPq.poll();
        }
        System.out.println(result);
    }

    static class Problem implements Comparable<Problem> {
        int no;
        int deadLine;
        int ramenCnt;

        public Problem(int no, int deadLine, int ramenCnt) {
            this.no = no;
            this.deadLine = deadLine;
            this.ramenCnt = ramenCnt;
        }

        @Override
        public int compareTo(Problem o) {
            if (deadLine == o.deadLine) {
               return o.ramenCnt - ramenCnt;
            }
            return deadLine - o.deadLine;
        }
    }
}
