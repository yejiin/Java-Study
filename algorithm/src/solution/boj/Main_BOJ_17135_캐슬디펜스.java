package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_17135_캐슬디펜스 {

    static int N, M, D;
    static int[][] map;

    static int[] archer;

    static int result;

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        archer = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(result);
    }

    // 궁수 위치 설정
    static void combination(int cnt, int start) {

        if (cnt == 3) {
            int[][] copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }
            result = Math.max(result, attack(copyMap));
            return;
        }

        for (int i = start; i < M; i++) {
            archer[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    static int attack(int[][] copyMap) {
        // 좌 상 우
        int[] dx = {0, -1, 0};
        int[] dy = {-1, 0, 1};

        int attackCnt = 0;

        for (int i = N; i > 0; i--) {  //  궁수가 한 칸 앞으로 전진
            int[][] attackLoc = new int[3][];  // 공격할 적의 위치
            for (int j = 0; j < 3; j++) {  // 궁수 3명
                Queue<int[]> queue = new LinkedList<>();
                boolean[][] visited = new boolean[N][M];
                int level = 0;
                boolean flag = false;

                int x = i - 1;
                int y = archer[j];
                queue.offer(new int[]{x, y});
                visited[x][y] = true;

                while (!queue.isEmpty()) {
                    int qSize = queue.size();
                    for (int q = 0; q < qSize; q++) {
                        int[] loc = queue.poll();
                        int curX = loc[0];
                        int curY = loc[1];

                        if (copyMap[curX][curY] == 1) {
                            attackLoc[j] = new int[] {curX, curY};
                            queue.clear();
                            break;
                        }

                        for (int k = 0; k < 3; k++) {
                            int nx = curX + dx[k];
                            int ny = curY + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                                continue;

                            if (!visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                        if (flag)
                            break;
                    }
                    if (++level == D)
                        break;
                }

            }

            // 공격 -> 1인 적 위치를 0으로
            for (int a = 0; a < 3; a++) {
                if (attackLoc[a] != null) {
                    if (copyMap[attackLoc[a][0]][attackLoc[a][1]] == 1) {
                        copyMap[attackLoc[a][0]][attackLoc[a][1]]= 0;
                        attackCnt++;
                    }
                }
            }
        }
        return attackCnt;
    }
}
