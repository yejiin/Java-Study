package solution.programmars.Lv2;

import java.util.Arrays;

public class Solution_Lv2_행렬테두리회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] graph = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                graph[i][j] = (i - 1) * columns + j;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int temp = 0;

            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            // 좌
            temp = graph[x1][y1];
            min = Math.min(min, temp);
            for (int j = x1 + 1; j <= x2; j++) {
                graph[j - 1][y1] = graph[j][y1];
                min = Math.min(min, graph[j - 1][y1]);
            }

            // 하
            for (int j = y1 + 1; j <= y2; j++) {
                graph[x2][j - 1] = graph[x2][j];
                min = Math.min(min, graph[x2][j - 1]);
            }

            // 우
            for (int j = x2 - 1; j >= x1; j--) {
                graph[j + 1][y2] = graph[j][y2];
                min = Math.min(min, graph[j + 1][y2]);
            }

            // 상
            for (int j = y2 - 1; j >= y1; j--) {
                graph[x1][j + 1] = graph[x1][j];
                min = Math.min(min, graph[x1][j + 1]);
            }

            graph[x1][y1 + 1] = temp;
            answer[i] = min;
        }
        return answer;
    }
}
