package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 출력 : 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간
public class Main_BOJ_17142_연구소3 {

    static int N, M;  // N: 연구소의 크기, M: 바이러스의 개수
    static int[][] map;  // 연구소 상태
    static ArrayList<int[]> virusLocations;  // 바이러스의 주어진 위치
    static int[] virusLocation;  // 바이러스를 놓을 위치
    static int blankCnt;  // 빈칸 개수
    static int result;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virusLocations = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 바이러스 일 때, 리스트에 위치 저장
                if (map[i][j] == 2)
                    virusLocations.add(new int[]{i, j});

                // 빈칸 개수 구하기
                if (map[i][j] == 0)
                    blankCnt++;
            }
        }

        result = N * N;
        virusLocation = new int[M];
        combination(0, 0);

        System.out.println(result == N * N ? -1 : result);
    }

    private static void combination(int cnt, int start) {

        if (cnt == M) {
            int time = move();

            if (time == -1)
                return;

            result = result > time ? time : result;

            return;
        }

        for (int i = start; i < virusLocations.size(); i++) {
            virusLocation[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    private static int move() {

        // map 복사
        int[][] m = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, m[i], 0, N);
        }

        // 활성 바이러스는 -1
        for (int i = 0; i < M; i++) {
            m[virusLocations.get(virusLocation[i])[0]][virusLocations.get(virusLocation[i])[1]] = -1;
        }

        Queue<Virus> q = new LinkedList<>();
        int blank = 0;  // 바이러스가 퍼진 빈칸 개수
        int spreadTime = 0;  // 바이러스 퍼진 시간

        for (int i = 0; i < M; i++) {
            q.offer(new Virus(virusLocations.get(virusLocation[i])[0], virusLocations.get(virusLocation[i])[1], 0));
        }

        while (!q.isEmpty()) {
            Virus cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (m[nx][ny] == 0) {
                    m[nx][ny] = -1;
                    spreadTime = spreadTime < cur.time + 1 ? cur.time + 1 : spreadTime;
                    blank++;
                    q.offer(new Virus(nx, ny, cur.time + 1));
                }

                if (blank == blankCnt)
                    break;

                if (m[nx][ny] == 2) {
                    m[nx][ny] = -1;
                    spreadTime = spreadTime < cur.time + 1 ? cur.time + 1 : spreadTime;
                    q.offer(new Virus(nx, ny, cur.time + 1));
                }
            }
        }

        // 모든 빈칸을 채우지 못할 경우
        if (blankCnt != blank)
            return -1;

        return spreadTime;
    }

    static class Virus {
        int x, y, time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}