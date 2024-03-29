package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N X N
 *
 * 1. 두 나라의 인구 차이가 L명 이상, R명 이하라면, 국경선을 하루 동안 연다.
 * 2. 국경선이 열려 있는 칸에 이동 가능(연합국)
 * 3. 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수)/(연합을 이루고 있는 칸의 개수), 소수점 버림
 * 4. 연합 해체, 국경선 닫는다.
 *
 * return : 인구 이동이 발생하는 총 일수
 */
public class Main_BOJ_16234_인구이동 {

    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day;
        for (day = 0; day < 2000; day++) {
            boolean[][] visited = new boolean[N][N];

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) {
                        continue;
                    }

                    if (union(i, j, visited)) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                break;
            }
        }
        System.out.println(day);
    }

    private static boolean union(int x, int y, boolean[][] visited) {
        List<int[]> unionCountry = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});

        int population = 0;
        int unionCnt = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]])
                continue;

            visited[cur[0]][cur[1]] = true;
            unionCountry.add(cur);
            population += map[cur[0]][cur[1]];
            unionCnt++;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    int[] next = {nx, ny};
                    queue.add(next);
                }
            }
        }

        if (unionCnt == 1) {
            return false;
        }

        int newPopulation = population / unionCnt;
        for (int[] country : unionCountry) {
            map[country[0]][country[1]] = newPopulation;
        }
        return true;
    }
}
