package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(in.readLine());
        int[][] room;

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(in.readLine());
            room = new int[N][N];

            // room 초기화
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };

            int resCnt = 0; // 최대 이동할 수 있는 방 개수
            int idx = 0; // 이동한 방

            int cntR = 1; // 현재방이 갈 수 있는 방 개수
            // room 순회하면서 방마다 이동할 수 있는 방으로 이동
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 현재 방 숫자
                    int curN = room[i][j];

                    // 4방향 확인하면서 순회
                    int x = i;
                    int y = j;
                    int nx = 0;
                    int ny = 0;
                    int nN = curN;
                    while (true) {
                        // 자신보다 1만큼 큰 방 있는지 확인
                        boolean flag = false;

                        for (int k = 0; k < 4; k++) {
                            nx = x + dx[k];
                            ny = y + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                                continue;

                            if (room[nx][ny] == nN + 1) {
                                nN++;
                                cntR++;
                                flag = true;
                                break;
                            }

                        }
                        x = nx;
                        y = ny;
                        if (!flag) {
                            break;
                        }

                    }

                    // 이동할 수 있는 방의 개수가 최대인 방 구하기
                    if (cntR > resCnt) {
                        resCnt = cntR;
                        idx = curN;
                    } else if (cntR == resCnt) {

                        if (idx > curN) {
                            idx = curN;

                        }
                    }
                    cntR = 1;
                }

            }
            sb.append("#").append(tc).append(" ").append(idx).append(" ").append(resCnt).append("\n");
        }
        System.out.println(sb);
    }

}