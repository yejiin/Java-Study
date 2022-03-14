package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 출력 : 추가해야 하는 가로선 개수의 최솟값
public class Main_BOJ_15684_사다리조작 {

    static int N, M, H;  // N: map의 가로 크기, M: 가로선 개수, H: map의 세로 크기  map[H][N]
    static int[][] map;
    static int count;
    static boolean finished;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 사다리 위치 저장
            map[a][b] = 1;  // 1: 오른쪽으로 이동
            map[a][b + 1] = 2;  // 2: 왼쪽으로 이동
        }

        // 사다리 한개씩 추가하며 사다리게임 끝나는지 확인
        for (; count <= 3; count++) {
            dfs(1, 0);
            if (finished)
                break;
        }
        System.out.println(!finished ? -1 : count);
    }

    // x: 행의 시작 위치, cnt: 놓인 사다리 개수
    private static void dfs(int x, int cnt) {
        if (count == cnt) {
            if (check())
                finished = true;
            return;
        }

        for (int i = x; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {  // 사다리를 놓을 자리에 사다리가 존재하는지 확인
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, cnt + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;
            while (x <= H) {
                if (map[x][y] == 1)
                    y++;
                else if (map[x][y] == 2)
                    y--;
                x++;
            }
            if (y != i) 
                return false;
        }
        return true;
    }
}
