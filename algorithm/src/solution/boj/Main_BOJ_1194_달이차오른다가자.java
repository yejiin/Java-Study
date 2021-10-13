package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// bfs
public class Main_BOJ_1194_달이차오른다가자 {

    static int N, M;
    static char[][] map;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Node {
        int x, y, count, key;

        public Node(int x, int y, int count, int key) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            map[i] = in.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        System.out.println(bfs(startX, startY));
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][64];  // a~f 열쇠 존재 여부는 비트마스킹 이용 (열쇠존재에 따라 0~63으로 나타낼 수 있음)

        q.offer(new Node(x, y, 0, 0));
        visited[x][y][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curx = cur.x;
            int cury = cur.y;
            int count = cur.count;
            int key = cur.key;

            if (map[curx][cury] == '1') { // 출구 만나면 종료
                return count;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curx + dx[d];
                int ny = cury + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (map[nx][ny] == '#' || visited[nx][ny][key])  // 벽일때, 이미 방문한 곳일때
                    continue;

                if (map[nx][ny] - 'a' >= 0 && map[nx][ny] - 'f' <= 0) {  // 열쇠일떼
                    int tempKey = (1 << (map[nx][ny] - 'a')) | key;  // 가지고 있는 열쇠와 발견한 열쇠 합치기

                    if (!visited[nx][ny][tempKey]) {
                        visited[nx][ny][tempKey] = true;
                        q.add(new Node(nx, ny, count + 1, tempKey));
                    }
                } else if (map[nx][ny] - 'A' >= 0 && map[nx][ny] - 'F' <= 0) {  // 문일떼
                    int tempDoor = (1 << (map[nx][ny] - 'A')) & key;  // 문에 맞는 열쇠 확인

                    if (tempDoor > 0) {  // 일치하는 열쇠가 있다면
                        visited[nx][ny][key] = true;
                        q.add(new Node(nx, ny, count + 1, key));
                    }
                } else {  // 빈곳일때(.)
                    visited[nx][ny][key] = true;
                    q.add(new Node(nx, ny, count + 1, key));
                }
            }
        }
        return -1;
    }
}
