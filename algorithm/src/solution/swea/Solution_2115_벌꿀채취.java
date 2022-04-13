package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_2115_벌꿀채취 {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] container = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    container[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            List<int[]> collectedHoney = new ArrayList<>();  // 두 개 데이터를 뽑아야 해서 리스트에 가능한 모든 수를 저장, (제일 오른쪽의 x,y좌표, 채취한 꿀의 양)

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {

                    int[] temp = Arrays.copyOfRange(container[i], j, j + M);  // 채취할 꿀 범위만 배열로

                    max = 0;
                    collect(0, 0, 0, M, C, temp);

                    collectedHoney.add(new int[]{i, j + M - 1, max});
                }
            }

            Collections.sort(collectedHoney, (o1, o2) -> o2[2] - o1[2]);

            int maxProfit = 0;
            int size = collectedHoney.size();
            for (int i = 0; i < size - 1; i++) {
                for (int j = i; j < size; j++) {
                    int[] temp1 = collectedHoney.get(i);
                    int[] temp2 = collectedHoney.get(j);
                    if (temp1[0] == temp2[0] && temp1[1] >= temp2[1] - M)  // 채취한 꿀이 겹치는 경우 패스
                        continue;

                    maxProfit = Math.max(maxProfit, temp1[2] + temp2[2]);

                }
            }
            sb.append("#").append(tc).append(" ").append(maxProfit).append("\n");
        }
        System.out.println(sb);
    }

    private static void collect(int cnt, int sum, int profit, int M, int C, int[] temp) {

        if (cnt == M) {
            if (sum <= C)
                max = Math.max(max, profit);
            return;
        }

        collect(cnt + 1, temp[cnt] + sum, profit + (temp[cnt] * temp[cnt]), M, C, temp);
        collect(cnt + 1, sum, profit, M, C, temp);
    }
}
