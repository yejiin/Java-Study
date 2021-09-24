package solution.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_17144_미세먼지안녕 {

    static int R, C, T;
    static int[][] map;
    static ArrayList<Dust> list; // 먼지 리스트
    static ArrayList<Integer> air; // 공기 청정기 x 좌표
    static int result;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Dust {
        int x, y, amount;

        public Dust(int x, int y, int amount) {
            super();
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        list = new ArrayList<>();
        air = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    list.add(new Dust(i, j, num));
                } else if (num == -1) {
                    map[i][j] = num;
                    air.add(i);
                }
            }
        }

        time(T);
        System.out.println(result);

    }

    private static void time(int second) {

        for (int t = 0; t < second; t++) {
            for (int i = 0; i < list.size(); i++) {
                Dust cur = list.get(i);

                int count = spread(cur.x, cur.y, cur.amount); // 미세먼지 확산. 확산시킨 방향 개수
                map[cur.x][cur.y] += cur.amount - (cur.amount / 5) * count; // 현재 좌표에 남은 미세먼지양

            }
            airclean(); // 공기청정기 작동

            findDust(); // 현재 남아 있는 먼지 찾기
        }

    }

    private static void findDust() {
        result = 0;
        list.clear();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int num = map[i][j];
                if (num >= 5) { // 미세먼지의 양이 5 미만이면 확산되지 않으므로 미세먼지(확산 가능한) 리스트에 저장하지 않음
                    list.add(new Dust(i, j, num));
                    map[i][j] = 0;
                }
                result += num;
            }
        }
        result += 2; // 미세먼지 양의 합에서 공기청정기값 없애기
    }

    private static void airclean() {

        int upx = air.get(0);
        int downx = air.get(1);

        int before = 0;
        int temp = 0;

        // 위쪽 공기청정기
        // 아래
        temp = map[upx][C - 1];
        for (int i = C - 1; i > 1; i--) {
            map[upx][i] = map[upx][i - 1];
        }
        map[upx][1] = 0;

        // 왼
        before = temp;
        temp = map[0][C - 1];
        for (int i = 0; i < upx; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        map[upx - 1][C - 1] = before;

        // 위
        before = temp;
        temp = map[0][0];
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        map[0][C - 2] = before;

        // 오른
        before = temp;
        for (int i = upx - 1; i > 1; i--) {
            map[i][0] = map[i - 1][0];
        }
        map[1][0] = before;

        // 아래쪽 공기 청정기
        // 위
        temp = map[downx][C - 1];
        for (int i = C - 1; i > 1; i--) {
            map[downx][i] = map[downx][i - 1];
        }
        map[downx][1] = 0;

        // 왼
        before = temp;
        temp = map[R - 1][C - 1];
        for (int i = R - 1; i > downx; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        map[downx + 1][C - 1] = before;

        // 아래
        before = temp;
        temp = map[R - 1][0];
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        map[R - 1][C - 2] = before;

        // 오른
        before = temp;
        for (int i = downx + 1; i < R - 2; i++) {
            map[i][0] = map[i + 1][0];
        }
        map[R - 2][0] = before;

    }

    private static int spread(int x, int y, int amount) {
        int cnt = 0;
        int nextA = amount / 5;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1)
                continue;
            map[nx][ny] += nextA;
            cnt++;
        }

        return cnt;
    }
}
