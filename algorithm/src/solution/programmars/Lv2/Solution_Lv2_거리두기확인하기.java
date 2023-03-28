package solution.programmars.Lv2;

import java.util.*;

public class Solution_Lv2_거리두기확인하기 {

    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();

        for (int tc = 0; tc < places.length; tc++) {
            String[] place = places[tc];

            char[][] map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                map[i] = place[i].toCharArray();
            }

            boolean checkDistance = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == 'P' && !bfs(i, j, map)) {
                        checkDistance = true;
                        break;
                    }
                }
            }
            answer.add(checkDistance ? 0 : 1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private boolean bfs(int x, int y, char[][] map) {
        boolean[][] visited = new boolean[5][5];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, false));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) {
                    continue;
                }

                if (cur.count + 1 == 2) {
                    if (cur.isOpened && map[nx][ny] == 'P')
                        return false;
                } else {
                    if (map[nx][ny] == 'P')
                        return false;
                    queue.add(new Node(nx, ny, cur.count + 1, map[nx][ny] == 'O'));
                }
            }
        }
        return true;
    }

    private class Node {
        int x;
        int y;
        int count;
        boolean isOpened;

        public Node(int x, int y, int count, boolean isOpened) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isOpened = isOpened;
        }
    }
}
