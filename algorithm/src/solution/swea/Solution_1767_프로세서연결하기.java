package solution.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// dfs
public class Solution_1767_프로세서연결하기 {

    static int N;
    static int[][] map;
    static ArrayList<int[]> cores;

    static int coreCnt, lineCnt, count;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            cores = new ArrayList<>(); // 코어 위치 저장

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    // 코어일 때, 멕시노스의 가장 자리가 아닐때(이미 전원에 연결됨)
                    if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        cores.add(new int[] { i, j });
                    }
                }
            }

            coreCnt = 0; // 코어 개수 초기화
            lineCnt = 0; // 전선 개수 초기화

            dfs(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(lineCnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int c, int line) {
        if (idx == cores.size()) {
            if (coreCnt < c) { // 그 전까지 선택된 코어 개수보다 현재 선택된 코어 개수가 많을 때
                coreCnt = c;
                lineCnt = line;
            } else if (coreCnt == c) { // 그 전까지 선택된 코어 개수가 현재 선택된 코어 개수와 같을 때
                if (lineCnt > line)
                    lineCnt = line;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (isConnect(cores.get(idx), i)) { // 연결 가능한지 확인
                fillLine(cores.get(idx), i, 2); // 전선 연결
                dfs(idx + 1, c + 1, line + count); // 다음 코어 선택
                fillLine(cores.get(idx), i, 0); // 전선 연결 해제
            }
        }
        dfs(idx + 1, c, line); // 코어 선택 안함
    }

    private static void fillLine(int[] core, int d, int value) {
        count = 0;

        int x = core[0] + dx[d];
        int y = core[1] + dy[d];

        while (x >= 0 && x < N && y >= 0 && y < N) {
            map[x][y] = value;
            count++;
            x = x + dx[d];
            y = y + dy[d];
        }

    }

    private static boolean isConnect(int[] core, int d) {
        int x = core[0] + dx[d];
        int y = core[1] + dy[d];

        while (x >= 0 && x < N && y >= 0 && y < N) {
            if (map[x][y] != 0)
                return false;
            x = x + dx[d];
            y = y + dy[d];
        }
        return true;
    }

}