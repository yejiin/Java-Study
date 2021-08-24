package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 정점 개수
            M = Integer.parseInt(st.nextToken()); // 간선 개수

            parents = new int[N + 1];
            make();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (s == 0) {
                    union(x, y);
                } else {
                    if (find(x) == find(y))
                        sb.append(1);
                    else
                        sb.append(0);

                }
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    private static void make() {

        for (int i = 0; i < N; i++) {
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
