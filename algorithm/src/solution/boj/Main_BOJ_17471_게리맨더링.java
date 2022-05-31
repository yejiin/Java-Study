package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17471_게리맨더링 {

    static int N;
    static int[] population;
    static boolean[][] map;

    static boolean[] region;
    static int regionCount;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        population = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++)
            population[i] = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken()) - 1;
                map[i][tmp] = true;
                map[tmp][i] = true;
            }
        }

        result = Integer.MAX_VALUE;
        region = new boolean[N];
        divideRegion(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void divideRegion(int cnt, int aRegionCnt) {
        if (cnt == N) {
            if (aRegionCnt > 0 && aRegionCnt < 6) {
                regionCount = 0;
                int diff = check();
                if (diff != -1)
                    result = Math.min(result, diff);
            }
            return;
        }

        region[cnt] = true;
        divideRegion(cnt + 1, aRegionCnt + 1);
        region[cnt] = false;
        divideRegion(cnt + 1, aRegionCnt);
    }

    private static int check() {
        int populationA = 0;
        int populationB = 0;

        boolean flagA = false, flagB = false;
        for (int i = 0; i < N; i++) {
            if (!flagA && region[i] ) {
                populationA = bfs(i, true);
                flagA = true;
            }

            if (!flagB && !region[i]) {
                populationB = bfs(i, false);
                flagB = true;
            }

            if (flagA && flagB)
                break;
        }

        if (regionCount == N)
            return Math.abs(populationA - populationB);

        return -1;
    }

    private static int bfs(int start, boolean status) {
        int totalPopulation = 0;

        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;
        regionCount++;
        totalPopulation += population[start];

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < N; i++) {
                if (map[cur][i] && !visited[i] && status == region[i]) {
                    q.offer(i);
                    visited[i] = true;
                    regionCount++;
                    totalPopulation += population[i];
                }
            }
        }

        return totalPopulation;
    }
}
