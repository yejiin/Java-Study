package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 출력 : 1번 상어만 격자에 남게 되는데 걸리는 시간
public class Main_BOJ_19237_어른상어 {

    static int N, M, K;  // N: 격자 크기, M: 상어 수, K: 냄새가 사라지는 시간
    static Node[][] smells;  // 상어 냄새 저장
    static Map<Integer, Shark> sharks;  // 상어 위치, 방향 저장 (1번부터)
    static Map<Integer, int[][]> directionPriority;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        smells = new Node[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                smells[i][j] = new Node();
        }

        sharks = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                int no = Integer.parseInt(st.nextToken());
                if (no > 0) {
                    sharks.put(no, new Shark(i, j));
                }
            }
        }

        // 상어 뱡향 저장 (0번부터)
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= M; i++)
            sharks.get(i).d = Integer.parseInt(st.nextToken()) - 1;

        directionPriority = new HashMap<>();
        for (int i = 1; i <= M; i++) {
            int[][] tempDir = new int[4][4];
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(in.readLine());
                for (int k = 0; k < 4; k++)
                   tempDir[j][k] = Integer.parseInt(st.nextToken());
            }
            directionPriority.put(i, tempDir);
        }

        smelling(); // 모든 상어가 자신의 위치에 자신의 냄새 뿌림

        for (int i = 1; i <= 1000; i++) {
            move();
            decreaseSmell();
            smelling();

            if (sharks.size() == 1) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void smelling() {
        for (Integer sharkNo : sharks.keySet()) {
            Shark shark = sharks.get(sharkNo);

            smells[shark.x][shark.y].sharkNo = sharkNo;
            smells[shark.x][shark.y].smell = K;
        }
    }

    private static void decreaseSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smells[i][j].sharkNo > 0)
                    smells[i][j].smell--;

                if (smells[i][j].smell == 0)
                    smells[i][j].sharkNo = 0;
            }
        }
    }

    private static void move() {
        int[][] visited = new int[N][N];

        ArrayList<Integer> keys = new ArrayList<>(sharks.keySet());
        for (Integer sharkNo : keys) {
            Shark shark = sharks.get(sharkNo);

            boolean flag = false;
            // 냄새 없는 칸으로 이동
            for (int d = 0; d < 4; d++) {
                int nd = directionPriority.get(sharkNo)[shark.d][d] - 1;
                int nx = shark.x + dx[nd];
                int ny = shark.y + dy[nd];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (smells[nx][ny].sharkNo == 0) {
                    nextMove(visited, sharkNo, nx, ny, nd);
                    flag = true;
                    break;
                }
            }

            if (flag)
                continue;

            // 냄새 없는 칸이 없는 경우
            for (int d = 0; d < 4; d++) {
                int nd = directionPriority.get(sharkNo)[shark.d][d] - 1;
                int nx = shark.x + dx[nd];
                int ny = shark.y + dy[nd];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (smells[nx][ny].sharkNo == sharkNo) {
                    nextMove(visited, sharkNo, nx, ny, nd);
                    break;
                }
            }
        }
    }

    private static void nextMove(int[][] visited, Integer sharkNo, int x, int y, int d) {
        if (visited[x][y] > 0) {
            int storedNo = visited[x][y];
            int removedNo = Math.max(sharkNo, storedNo);
            if (removedNo == storedNo) {
                visited[x][y] = sharkNo;

                Shark shark = sharks.get(sharkNo);
                shark.x = x;
                shark.y = y;
                shark.d = d;
            }
            sharks.remove(removedNo);
        } else {
            visited[x][y] = sharkNo;

            Shark shark = sharks.get(sharkNo);
            shark.x = x;
            shark.y = y;
            shark.d = d;
        }
    }

    static class Node {
        int sharkNo, smell;
    }

    static class Shark {
        int x, y, d;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
