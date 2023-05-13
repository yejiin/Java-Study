package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_23835_어떤우유의배달목록_LinkedList {

    static int N, Q;

    static List<Integer>[] map;
    static int[] milk;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());
        map = new LinkedList[N + 1];

        milk = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {  // 비밀 통로
            st = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1].add(n2);
            map[n2].add(n1);
        }

        Q = Integer.parseInt(in.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(in.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                int[] visited = new int[N + 1]; // 방문 여부(>0), 전달할 우유 개수
                visited[start] = -1;
                delivery(start, end, start, 1, visited);
            } else {
                System.out.println(milk[Integer.parseInt(st.nextToken())]);
            }
        }
    }

    private static void delivery(int start, int end, int cur, int i, int[] visited) {  // (i개 전달, 현재 방 번호, 도착 방, visited)
        if (cur == end) {
            for (int j = 1; j <= N; j++) {
                if (j == start)
                    continue;
                milk[j] += visited[j];
            }
            return;
        }

        List<Integer> nearRooms = map[cur];
        for (Integer n : nearRooms) {
            if (visited[n] == 0) {
                visited[n] += i;
                delivery(start, end, n, i + 1, visited);
                visited[n] -= i;
            }
        }
    }
}
