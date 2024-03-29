package solution.programmars.Lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 분석
 * - 한 번 이동할 때 장애물에 부딪히거나 끝까지 이동
 * - output : 시작 위치에서 목표 위치까지 최소 이동수, 불가능 -1
 *
 * 풀이
 * 1. board 2차원 배열로, start 위치 저장
 * 2. bfs
 *   queue 에 x, y, count 저장
 *   2-1. 상하좌우로 장애물, board 끝까지 이동
 *   2-2. end 위치에 도달하면 종료
 *
 * 주의
 * bfs 사용할 때 방문(visited) 고려
 */
public class Solution_Lv2_리코쳇로봇 {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1 ,1};

    public int solution(String[] board) {
        char[][] boardArr = new char[board.length][board[0].length()];
        int[] start = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                boardArr[i][j] = board[i].charAt(j);

                if (boardArr[i][j] == 'R') {
                    start = new int[]{i, j};
                }
            }
        }

        int answer = bfs(boardArr, start, board.length, board[0].length());
        return answer == 0 ? -1 : answer;
    }

    private static int bfs(char[][] boardArr, int[] start, int h, int w) {
        boolean[][] visited = new boolean[h][w];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x;
                int ny = cur.y;

                do{
                    nx += dx[d];
                    ny += dy[d];
                } while (nx >= 0 && nx < h && ny >= 0 && ny < w && boardArr[nx][ny] != 'D');

                nx -= dx[d];
                ny -= dy[d];

                if (visited[nx][ny])
                    continue;

                if (boardArr[nx][ny] == 'G') {
                    return cur.count + 1;
                }

                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, cur.count + 1));
            }
        }
        return 0;
    }

    static class Node {
        private int x;
        private int y;
        private int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}