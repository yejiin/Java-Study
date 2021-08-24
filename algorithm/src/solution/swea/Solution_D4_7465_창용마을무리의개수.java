package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N + 1];

            make();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Set<Integer> result = new HashSet<>();

            for (int i = 1; i <= N; i++) {
                result.add(find(i));
            }
            sb.append("#").append(tc).append(" ").append(result.size()).append("\n");
        }
        System.out.println(sb);

    }

    private static void make() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int x) {
        if (x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot)
            return false;

        parents[yRoot] = xRoot;
        return true;
    }
}
