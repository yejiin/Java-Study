package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_21608_상어초등학교 {

    static int N;
    static int[][] favorite;  // index 를 학생 번호로 좋아하는 학생 저장
    static int[][] classRoom;  // 교실
    static int[] satisfaction = {0, 1, 10, 100, 1000};

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        favorite = new int[N * N + 1][4];
        classRoom = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++)
                favorite[s][j] = Integer.parseInt(st.nextToken());
            findLocation(s);
        }

        System.out.println(sumSatisfaction());
    }

    private static void findLocation(int sno) {

        List<Location> pLocation = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (classRoom[i][j] == 0) {  // 비어있는 자리 주변 확인
                    int[] cnt = countFavoriteAndEmpty(sno, i, j);
                    pLocation.add(new Location(i, j, cnt[0], cnt[1]));
                }
            }
        }
        Collections.sort(pLocation);

        Location loc = pLocation.get(0);
        classRoom[loc.x][loc.y] = sno;
    }

    private static int[] countFavoriteAndEmpty(int sno, int x, int y) {

        int[] cnt = new int[2];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if (classRoom[nx][ny] == 0) {
                cnt[1]++;
                continue;
            }

            int nearStudent = classRoom[nx][ny];

            for (int i = 0; i < 4; i++) {
                if (favorite[sno][i] == nearStudent) {
                    cnt[0]++;
                    break;
                }
            }
        }
        return cnt;
    }

    private static int sumSatisfaction() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    int nearStudent = classRoom[nx][ny];

                    for (int k = 0; k < 4; k++) {
                        if (favorite[classRoom[i][j]][k] == nearStudent)
                            cnt++;
                    }
                }
                sum += satisfaction[cnt];
            }
        }
        return sum;
    }

    static class Location implements Comparable<Location> {
        int x, y;
        int favoriteCnt, emptyCnt;

        public Location(int x, int y, int favoriteCnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.favoriteCnt = favoriteCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Location o) {

            if (this.favoriteCnt == o.favoriteCnt) {
                if (this.emptyCnt == o.emptyCnt) {
                    if (this.x == o.x)
                        return this.y - o.y;
                    return this.x - o.x;
                }
                return o.emptyCnt - this.emptyCnt;
            }
            return o.favoriteCnt - this.favoriteCnt;
        }
    }
}
