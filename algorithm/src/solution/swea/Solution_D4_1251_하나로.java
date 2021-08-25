package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(in.readLine());
            int[][] data = new int[N][2];

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                data[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                data[i][1] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(in.readLine());
            boolean[] visited = new boolean[N];
            double[] distance = new double[N];
            Arrays.fill(distance, Double.MAX_VALUE);

            double result = 0;
            distance[0] = 0;

            for (int i = 0; i < N; i++) {
                double min = Double.MAX_VALUE;
                int minVertex = -1;
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && min > distance[j]) {
                        min = distance[j];
                        minVertex = j;
                    }
                }

                visited[minVertex] = true;
                result += min;

                for (int j = 0; j < N; j++) {
                    if (!visited[j]) {
                        double vertexCost = (Math.pow(data[minVertex][0] - data[j][0], 2) + Math.pow(data[minVertex][1] - data[j][1], 2));
                        vertexCost *= E;
                        distance[j] = Math.min(distance[j], vertexCost);
                    }
                }

            }
            sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");

        }
        System.out.println(sb);
    }
}
