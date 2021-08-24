package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1753_최단경로 {

    static class Edge {
        int end, weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
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
        List<Edge>[] data = new List[V];
        for (int i = 0; i < V; i++) {
            data[i] = new ArrayList<>();
        }
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            data[start].add(new Edge(end, weight));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        int min = 0, current = K;
        for (int i = 0; i < V; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }

            visited[current] = true;

            for (int j = 0; j < data[current].size(); j++) {
                Edge cur = data[current].get(j);
                if (!visited[cur.end] && distance[cur.end] > min + cur.weight) {
                    distance[cur.end] = min + cur.weight;
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
