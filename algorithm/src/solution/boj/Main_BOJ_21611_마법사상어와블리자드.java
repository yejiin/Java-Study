package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_21611_마법사상어와블리자드 {

    static int N, M;
    static int[][] map;
    static int[] shark;

    static int result;

    static Queue<Integer> q;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        shark = new int[]{N / 2, N / 2};

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            destroyMarble(shark[0], shark[1], Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));

            if (!check())
                continue;

            moveMarble(shark[0], shark[1]);
            while(true) {
                if(!explosion()) {
                    countMarble();
                    break;
                }
            }

            addMarble(shark[0], shark[1]);
            q.clear();
        }
        System.out.println(result);
    }

    // 구슬 파괴, 0으로
    private static void destroyMarble(int x, int y, int d, int s) {
        for (int i = 0; i < s; i++) {
            x += dx[d];
            y += dy[d];

            map[x][y] = 0;
        }
    }

    // 구슬이 있는지 확인
    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > 0)
                    return true;
            }
        }
        return false;
    }

    // 구슬 이동, 파괴 되지 않은(0이 아닌) 구슬은 q에 넣어줌
    private static void moveMarble(int x, int y) {
        int distance = 1;
        while (true) {
            for (int i = 0; i < distance; i++) {  // 왼쪽 이동
                int no = map[x][--y];
                if (no != 0)
                    q.offer(no);

                map[x][y] = 0;

                if (x == 0 && y == 0) return;
            }

            for (int i = 0; i < distance; i++) {
                int no = map[++x][y];
                if (no != 0)
                    q.offer(no);

                map[x][y] = 0;
            }

            distance++;

            for (int i = 0; i < distance; i++) {
                int no = map[x][++y];
                if (no != 0)
                    q.offer(no);

                map[x][y] = 0;
            }

            for (int i = 0; i < distance; i++) {
                int no = map[--x][y];
                if (no != 0)
                    q.offer(no);

                map[x][y] = 0;
            }
            distance++;
        }
    }

    // 폭발
    private static boolean explosion() {
        boolean isExplosion = false;
        int size = q.size();

        if (size == 0)
            return false;

        int beforeMarble = q.poll();
        int cnt = 1;

        for (int i = 0; i < size - 1; i++) {
            int marble = q.poll();

            if (beforeMarble == marble) {  // 같은 경우, cnt++
                cnt++;
            } else {  // 같지 않은 경우, 개수 4이상이면 건너뛰기
                if (cnt < 4) {
                    for (int j = 0; j < cnt; j++)
                        q.offer(beforeMarble);

                } else {
                    result += (beforeMarble * cnt);
                    isExplosion = true;
                }
                beforeMarble = marble;
                cnt = 1;
            }
        }

        if (cnt < 4){
            for (int j = 0; j < cnt; j++)
                q.offer(beforeMarble);
        } else {
            result += (beforeMarble * cnt);
        }

        return isExplosion;
    }

    private static void countMarble() {
        int size = q.size();

        if (size == 0)
            return;

        int beforeMarble = q.poll();
        int cnt = 1;
        for (int i = 0; i < size - 1; i++) {
            int marble = q.poll();

            if (beforeMarble == marble) {  // 같은 경우, cnt++
                cnt++;
            } else {
                q.offer(cnt);
                q.offer(beforeMarble);
                beforeMarble = marble;
                cnt = 1;
            }
        }
        q.offer(cnt);
        q.offer(beforeMarble);
    }

    private static void addMarble(int x, int y) {
        int distance = 1;
        while (true) {

            for (int i = 0; i < distance; i++) {
                if (q.isEmpty())
                    return;

                map[x][--y] = q.poll();

                if (x == 0 && y == 0) return;
            }

            for (int i = 0; i < distance; i++) {
                if (q.isEmpty())
                    return;

                map[++x][y] = q.poll();
            }

            distance++;

            for (int i = 0; i < distance; i++) {
                if (q.isEmpty())
                    return;

                map[x][++y] = q.poll();
            }

            for (int i = 0; i < distance; i++) {
                if (q.isEmpty())
                    return;

                map[--x][y] = q.poll();
            }
            distance++;
        }
    }
}
