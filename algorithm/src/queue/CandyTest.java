package queue;

import java.util.LinkedList;
import java.util.Queue;

public class CandyTest {

    public static void main(String[] args) {
        int N = 20;
        Queue<int[]> queue = new LinkedList<>();  // 사람 번호, 사탕 개수
        int person = 1;

        queue.offer(new int[] {person, 1});

        while (N > 0) {
            if (!queue.isEmpty()) {
                int[] p = queue.poll();
                int availableCnt = (N >= p[1]) ? p[1] : N;
                N -= availableCnt;

                if (N == 0) {
                    System.out.println("마지막 사탕을 가져간 사람 : " + p[0] + "번, 가져간 개수 : " + availableCnt);
                } else {
                    System.out.println(p[0] + "번이 " + availableCnt + "만큼 사탕을 가져갑니다.");
                    p[1]++;  // 받고자 하는 사탕 개수 증가
                    queue.offer(p);
                    queue.offer(new int[]{+person, 1});
                }
            }
        }
    }
}
