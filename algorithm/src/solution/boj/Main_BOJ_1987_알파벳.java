package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳 {

    static int R, C;
    static char[][] board;
    static boolean[] visited;
    static int result;
    static int cnt;

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[26];
        result = 1;
        cnt = 1;

        for (int i = 0; i < R; i++) {
            board[i] = in.readLine().toCharArray();
        }

        move(0, 0);

        System.out.println(result);

    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    private static void move(int x, int y) {

        int idx = board[x][y] - 'A';
        visited[idx] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                continue;

            if (!visited[board[nx][ny] - 'A']) {
                result = Math.max(++cnt, result);
                move(nx, ny);
            }
        }
        --cnt;
        visited[idx] = false;
    }

}

