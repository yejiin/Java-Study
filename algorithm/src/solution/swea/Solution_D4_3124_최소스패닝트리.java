package solution.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리 {

    static int V, E;
    static Edge[] edgeList;
    static int[] parents;

    static class Edge implements Comparable<Edge> {

        int start, end, weight;

        public Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static void make() {
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E];
            parents = new int[V + 1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(start, end, weight);
            }

            Arrays.sort(edgeList);

            make();

            int cnt = 0;
            long result = 0;
            for (Edge edge : edgeList) {
                if (union(edge.start, edge.end)) {
                    result += edge.weight;
                    if (++cnt == V - 1)
                        break;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
