package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 출력 : 청소하는 영역의 개수
public class Main_BOJ_14503_로봇청소기 {

    static int N, M;
    static int[][] map;

    static int cleanCnt;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int vacuumX = Integer.parseInt(st.nextToken()) ;
        int vacuumY = Integer.parseInt(st.nextToken()) ;
        int vacuumD = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(vacuumX, vacuumY, vacuumD);

        System.out.println(cleanCnt);
    }

    private static void clean(int vacuumX, int vacuumY, int vacuumD) {
        Deque<int[]> dq = new LinkedList<>();
        dq.offer(new int[] {vacuumX, vacuumY, vacuumD});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            // 현재 위치 청소
            if (map[cur[0]][cur[1]] == 0) {
                cleanCnt++;
                map[cur[0]][cur[1]] = 2;
            }

            boolean flag = false;

            // 왼쪽 방향 확인
            for (int d = 0; d < 4; d++) {
                int nd = (cur[2] + 3 - d) % 4;
                int nx = cur[0] + dx[nd];
                int ny = cur[1] + dy[nd];

                // 왼쪽 방향에 청소할 공간이 없는 경우
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0)
                    continue;

                // 청소하지 않는 공간이 존재 할 때
                dq.offer(new int[] {nx, ny, nd});
                flag = true;
                break;
            }

            if (!flag) {
                // 뒤로 후진
                int nx = cur[0] + dx[(cur[2] + 2) % 4];
                int ny = cur[1] + dy[(cur[2] + 2) % 4];

                // 뒤로 갈 수 있는 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1) {
                    dq.addFirst(new int[] {nx, ny, cur[2]});  // dq 앞에 삽입
                }
            }
        }
    }
}
