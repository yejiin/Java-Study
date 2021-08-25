package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_10026_적록색약 {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        char[][] pic1 = new char[N][N]; // 적록색약이 아닌 사람의 그림
        char[][] pic2 = new char[N][N]; // 적록색약인 사람의 그림

        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                char c = str.charAt(j);
                pic1[i][j] = c;
                if (c == 'G') // 적록색약인 사람의 그림 G색을 R로 바꿈
                    pic2[i][j] = 'R';
                else
                    pic2[i][j] = c;
            }
        }

        System.out.println(find(pic1, N) + " " + find(pic2, N));
    }

    private static int find(char[][] pic, int N) {

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<int[]>();

        int cnt = 0; // 구역의 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;

                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                                continue;

                            if (!visited[nx][ny] && pic[nx][ny] == pic[i][j]) {
                                queue.offer(new int[] { nx, ny });
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}