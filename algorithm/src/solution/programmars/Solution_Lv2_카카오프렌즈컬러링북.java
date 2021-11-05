package solution.programmars;

import java.lang.Math;
import java.util.*;

public class Solution_Lv2_카카오프렌즈컬러링북 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int[] solution(int m, int n, int[][] picture) {
        int[][] map = copy(picture);

        int[] answer = findArea(m, n, map);

        return answer;
    }

    public int[] findArea(int m, int n, int[][] map) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int size = 0;
                int num = map[i][j];

                if (num == 0)
                    continue;

                q.offer(new int[] {i, j});
                map[i][j] = 0;
                size++;
                numberOfArea++;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cx = cur[0];
                    int cy = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                            continue;

                        if (map[nx][ny] == num) {
                            q.offer(new int[]{nx, ny});
                            map[nx][ny] = 0;
                            size++;
                        }
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
            }
        }

        return new int[] {numberOfArea, maxSizeOfOneArea};
    }

    public int[][] copy(int[][] picture) {

        int[][] map = new int[picture.length][picture[0].length];

        for (int i = 0; i < map.length; i++) {
            System.arraycopy(picture[i], 0, map[i], 0, picture[0].length);
        }

        return map;
    }
}