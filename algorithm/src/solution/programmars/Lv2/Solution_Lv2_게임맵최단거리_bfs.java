package solution.programmars.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lv2_게임맵최단거리_bfs {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 , -1, 1};

    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[N][M];

        visited[0][0] = 1;
        q.offer(new Node(0, 0, 1));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = cur.count + 1;
                        q.offer(new Node(nx, ny, cur.count + 1));
                    }
                }
            }
        }
        return visited[N - 1][M - 1] == 0 ? -1 : visited[N - 1][M - 1];
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}