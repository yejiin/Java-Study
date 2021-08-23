package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS {

    static int N, M, V;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = graph[to][from] = true;
        }

        boolean[] visited = new boolean[N + 1];
        dfs(V, visited);
        System.out.println();
        bfs();

    }

    private static void dfs(int current, boolean[] visited) {

        visited[current] = true;
        System.out.print(current + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[current][i])
                dfs(i, visited);
        }

    }

    private static void bfs() {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            System.out.print(current + " ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[current][i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
