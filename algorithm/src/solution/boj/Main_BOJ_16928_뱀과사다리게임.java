package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16928_뱀과사다리게임 {

    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        move = new int[101];

        st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            move[x] = y;
        }
        System.out.println(countMinMove(1));
    }

    private static int countMinMove(int start) {
        int[] cnt = new int[101];
        Arrays.fill(cnt, 100);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        cnt[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= 6; i++) {
                if (cur + i > 100)
                    continue;

                int next = cur + i;
                if (move[cur + i] != 0)
                    next = move[cur + i];

                // 기존에 있는 값이 크면
                if (cnt[cur] + 1 < cnt[next]) {
                    cnt[next] = cnt[cur] + 1;
                    q.offer(next);
                }
            }

        }
        return cnt[100];
    }
}
