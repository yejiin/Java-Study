package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1753_최단경로_PQ {

    static class Edge implements Comparable<Edge>{
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(in.readLine()) - 1;

        List<Edge>[] graph = new List[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(K, 0));
        distance[K] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            for (int j = 0; j < graph[cur.v].size(); j++) {
                Edge temp = graph[cur.v].get(j);
                if (distance[temp.v] > distance[cur.v] + temp.w) {
                    distance[temp.v] = distance[cur.v] + temp.w;
                    q.offer(new Edge(temp.v, distance[temp.v]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            int d = distance[i];
            if (d == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(d).append("\n");
        }
        System.out.println(sb);
    }
}
