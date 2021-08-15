package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cntR; // 현재방이 갈 수 있는 방 개수

    public static void main(String[] args) throws NumberFormatException, IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(in.readLine());
            int[][] room = new int[N][N];

            // room 초기화
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxR = 0; // 최대 이동할 수 있는 방 개수
            int idxR = Integer.MAX_VALUE; // 이동한 방

            // room 순회하면서 방마다 이동할 수 있는 방으로 이동
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cntR = 1;
                    getCount(room, i, j, room[i][j]);

                    if (maxR <= cntR) {
                        if (maxR == cntR) {
                            idxR = Math.min(room[i][j], idxR);
                        } else {
                            idxR = room[i][j];
                        }
                        maxR = cntR;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(idxR).append(" ").append(maxR).append("\n");
        }
        System.out.println(sb);
    }

    private static void getCount(int[][] room, int curX, int curY, int curNum) {

        int len = room.length;

        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];

            if (nx >= 0 && nx < len && ny >= 0 && ny < len && room[nx][ny] == curNum + 1) {
                cntR++;
                getCount(room, nx, ny, curNum + 1);
            }
        }
    }
}