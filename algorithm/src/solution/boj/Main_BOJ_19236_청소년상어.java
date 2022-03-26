package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_19236_청소년상어 {

    static int[][] map;
    static int[][] fishes;
    static int result;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[4][4];  // 물고기 번호 저장
        fishes = new int[16][3];  // 물고기 방향

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                int fishNum = Integer.parseInt(st.nextToken()) - 1;
                int fishDir = Integer.parseInt(st.nextToken()) - 1;

                map[i][j] = fishNum;
                fishes[fishNum] = new int[] {i, j, fishDir};
            }
        }

        int num = map[0][0];
        int d = fishes[num][2];
        map[0][0] = -1;
        fishes[num][0] = -1;

        dfs(0, 0, d, num + 1, map, fishes);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int d, int sumFish, int[][] map, int[][] fishes) {

        moveFish(map, fishes, x, y);

        // 최대 3번 이동
        for (int i = 1; i <= 3; i++) {

            int nx = x + dx[d] * i;
            int ny = y + dy[d] * i;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || map[nx][ny] == -1)
                continue;

            int[][] tempMap = copyMap(map);
            int[][] tempFish = copyFish(fishes);
            int num = tempMap[nx][ny];
            int nd = tempFish[num][2];
            tempMap[nx][ny] = -1;
            tempFish[num][0] = -1;

            dfs(nx, ny, nd, sumFish + (num + 1), tempMap, tempFish);
        }
        result = Math.max(result, sumFish);
    }

    private static int[][] copyMap(int[][] map) {
        int[][] tempMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, 4);
        }
        return tempMap;
    }

    private static int[][] copyFish(int[][] fishDirection) {
        int[][] temp = new int[fishDirection.length][fishDirection[0].length];

        for (int i = 0; i < fishDirection.length; i++) {
            for (int j = 0; j < fishDirection[0].length; j++) {
                temp[i][j] = fishDirection[i][j];
            }
        }
        return temp;
    }

    private static void moveFish(int[][] map, int[][] fishes, int x, int y) {
        // 순서대로 물고기 이동
        for (int i = 0; i < fishes.length; i++) {
            int[] fish = fishes[i];

            if (fish[0] == -1)
                continue;

            for (int d = 0; d < 8; d++) {
                int nd = (fish[2] + d) % 8;
                int nx = fish[0] + dx[nd];
                int ny = fish[1] + dy[nd];

                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == x && ny == y))
                    continue;

                if (map[nx][ny] == -1) {  // 빈공간이라면
                    map[fish[0]][fish[1]] = -1;
                    map[nx][ny] = i;
                } else if (map[nx][ny] >= 0 && map[nx][ny] <= 15) {
                    int temp = map[nx][ny];
                    map[nx][ny] = i;
                    map[fish[0]][fish[1]] = temp;
                    fishes[temp] = new int[]{fish[0], fish[1], fishes[temp][2]};
                }
                fishes[i] = new int[]{nx, ny, nd};
                break;
            }
        }
    }
}
