package solution.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_9205_맥주마시면서걸어가기 {

    public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(in.readLine());
            List<int[]> points = new ArrayList<int[]>(); // point는 집, 편의점, 페스티벌 좌표 저장
            int[][] dist = new int[N + 2][N + 2]; // 노드는 집, 편의점, 페스티벌, value는 노드간 거리
            boolean[][] d = new boolean[N + 2][N + 2]; // 노드끼리 방문가능한지

            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                points.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });

            }

            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    int[] p1 = points.get(i);
                    int[] p2 = points.get(j);
                    dist[i][j] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                    if (dist[i][j] <= 20 * 50) { // 거리가 20 * 50 미터 이하면 방문 가능
                        d[i][j] = true;
                        d[j][i] = true;
                    }

                }
            }

            for (int k = 0; k < N + 2; k++) {
                for (int i = 0; i < N + 2; i++) {
                    for (int j = 0; j < N + 2; j++) {
                        if (d[i][k] & d[k][j]) // 다른 노드를 방문해서 방문 가능한 경우
                            d[i][j] = true;
                    }
                }
            }

            System.out.println(d[0][N + 1] ? "happy" : "sad");
        }
    }
}
