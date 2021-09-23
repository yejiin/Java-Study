package solution.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());

        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        visited[0] = true;
        delivery(0, 0, 0);

        System.out.println(result);
    }

    private static void delivery(int dept, int v, int cost) {
        if (dept == N - 1) {
            if (map[v][0] == 0) {
                return;
            }

            cost += map[v][0];
            result = Math.min(cost, result);
            return;
        }

        for (int i = 1; i < N; i++) {
            if (visited[i] || map[v][i] == 0)
                continue;

            if (cost + map[v][i] > result)
                continue;

            visited[i] = true;
            delivery(dept + 1, i, cost + map[v][i]);
            visited[i] = false;
        }
    }
}