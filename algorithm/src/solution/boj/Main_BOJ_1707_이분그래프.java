package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_1707_이분그래프 {

    static int V, E;
    static ArrayList<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V];
            for (int i = 0; i < V; i++)
                list[i] = new ArrayList<>();

            visited = new int[V];  // 집합을 1, 2로 나눔 (0은 방문 안한 노드)

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken()) - 1;
                int v2 = Integer.parseInt(st.nextToken()) - 1;
                list[v1].add(v2);
                list[v2].add(v1);
            }

            bfs();
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                q.offer(i);
            }

            while(!q.isEmpty()) {
                int curV = q.poll();

                for (int j = 0; j < list[curV].size(); j++) {
                    int nextV = list[curV].get(j);

                    if (visited[nextV] == visited[curV]) {  // 인접 노드끼리 집합 번호가 같다면 이분 그래프가 아니다.
                        System.out.println("NO");
                        return;
                    }

                    if (visited[nextV] == 0) {  // 현재 노드로부터 인접한 노드의 집합을 다른 집합으로 지정 (현재 집합이 1이면 인접 집합을 2로)
                        if (visited[curV] == 1) {
                            visited[nextV] = 2;
                        } else if (visited[curV] == 2) {
                            visited[nextV] = 1;
                        }

                        q.offer(nextV);
                    }
                }
            }
        }
        System.out.println("YES");
    }

}
