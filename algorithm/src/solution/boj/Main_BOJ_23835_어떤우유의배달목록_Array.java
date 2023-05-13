package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 방(1-N번방), N - 1개의 비밀 통로(양방향 연결)
 * output : 배달한 우유의 수
 *
 * => 2차원 배열 : 1412ms
 * => Linked List : 272ms
 */
public class Main_BOJ_23835_어떤우유의배달목록_Array {

    static int N, Q;

    static int[][] map;  // 1: 연결
    static int[] milk;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());
        map = new int[N + 1][N + 1];
        milk = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {  // 비밀 통로
            st = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1][n2] = 1;
            map[n2][n1] = 1;
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

        for (int n = 1; n <= N; n++) {
            // 연결 확인
            if (map[cur][n] == 1 && visited[n] == 0) {
                visited[n] += i;
                delivery(start, end, n, i + 1, visited);
                visited[n] -= i;
            }
        }
    }
}
