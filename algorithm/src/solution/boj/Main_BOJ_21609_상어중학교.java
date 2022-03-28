package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 출력 : 획득한 점수의 합
public class Main_BOJ_21609_상어중학교 {

    static int N, M;
    static int[][] board;
    static int result;
    static boolean[][] v;

    static int[] dx = {-1 ,1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            // 블록 그룹 찾기 (없으면 종료)
            v = new boolean[N][N];
            boolean[][] group = find();
            if (group == null)
                break;

            remove(group);
            gravity();
            rotate();
            gravity();
        }
        System.out.println(result);
    }

    private static boolean[][] find() {
        Queue<int[]> q = new LinkedList<>();

        int[] groupInfo = new int[4];
        boolean[][] group = null;

        // 격자 돌면서 그룹생성
        // (i, j)부터 그룹 생성, 무지개 블록 수가 같다면 나중에 구한 그룹이 블록 그룹
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                boolean[][] visited = new boolean[N][N];  // true: 그룹에 속한 블록
                int[] curGroupInfo = new int[4];  // 블록 개수, 무지개 개수, 기준행, 기준열

                if (board[i][j] <= 0 || (group != null && group[i][j]))
                    continue;

                q.offer(new int[]{i, j});
                visited[i][j] = true;
                curGroupInfo[0]++;
                curGroupInfo[2] = i;
                curGroupInfo[3] = j;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];


                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || board[nx][ny] < 0)
                            continue;

                        if (board[nx][ny] > 0 && (board[nx][ny] != board[i][j]))
                            continue;

                        if (board[nx][ny] == 0)
                            curGroupInfo[1]++;
                        else{
                            if (nx < curGroupInfo[2] || (nx == curGroupInfo[2] && ny < curGroupInfo[3])) {
                                curGroupInfo[2] = nx; curGroupInfo[3] = ny;
                            }
                        }

                        curGroupInfo[0]++;
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

                if (curGroupInfo[0] > 1) {
                    for (int k = 0; k < 4; k++) {
                        if (groupInfo[k] == curGroupInfo[k])
                            continue;
                        else if (groupInfo[k] < curGroupInfo[k]) {
                            groupInfo = curGroupInfo;
                            group = visited;
                        }
                        break;
                    }
                }
            }
        }
        return group;
    }

    private static void remove(boolean[][] group) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (group[i][j]) {
                    board[i][j] = -2;  // -2 : 제거
                    cnt++;
                }
            }
        }
        result += cnt * cnt;
    }


    private static void gravity() {
        for (int c = 0; c < N; c++) { // 각 열별로 확인
            for (int r = N - 1; r >= 0; r--) { // 가장 아래 블록부터 아래로 내려감
                int block = board[r][c];

                // 내려가지 않는 블록이라면
                if (block <= -1) {
                    continue;
                }
                // 내려가는 블록이라면
                board[r][c] = -2;
                int nr = r;
                while (nr < N && board[nr][c] == -2) {
                    nr++;
                }
                board[nr - 1][c] = block;
            }
        }
    }

    private static void rotate() {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = board[j][N -i - 1];
            }
        }
        board = temp;
    }
}
