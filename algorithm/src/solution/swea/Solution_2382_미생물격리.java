package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<int[]> clusters = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                clusters.add(new int[] {x, y, cnt, dir});
            }

            for (int i = 1; i <= M; i++)
                clusters = move(clusters, N);

            sb.append("#").append(tc).append(" ").append(countMicro(clusters)).append("\n");
        }
        System.out.println(sb);
    }

    private static List<int[]> move(List<int[]> clusters, int N) {
        List<int[]> tmpClusters = new ArrayList<>(); // {x, y, 미생물 수, 방향, 최대 군집의 미생물 수}
        int[][] visited = new int[N][N]; // 미생물 집단의 번호 저장 (1~)

        for (int[] cur : clusters) {
            int nd = cur[3];
            int nx = cur[0] + dx[nd];
            int ny = cur[1] + dy[nd];
            int ncnt = cur[2];

            if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {  // 약품이 칠해진 곳일 때
                nd += cur[3] % 2 == 0 ? 1 : -1;  // 반대방향으로
                ncnt /= 2;  // 미생물 절반이 죽음

                if (ncnt == 0)
                    continue;
            }

            if (visited[nx][ny] > 0) {  // 다른 미생물 군단이 존재할 때, 합쳐지기
                int[] prev = tmpClusters.get(visited[nx][ny] - 1);  // 미생물 군단의 번호는 0번부터
                if(prev[4] < ncnt) { // 더 큰 군집의 방향으로 바꿈
                    prev[3] = nd;
                    prev[4] = ncnt;
                }
                prev[2] += ncnt;  // 미생물 수 합침
                continue;
            } else {
                visited[nx][ny] = tmpClusters.size() + 1;
            }

            tmpClusters.add(new int[] {nx, ny, ncnt, nd, ncnt});
        }

        return tmpClusters;
    }

    private static int countMicro(List<int[]> clusters) {
        int sum = 0;
        for (int[] cluster : clusters)
            sum += cluster[2];

        return sum;
    }
}
