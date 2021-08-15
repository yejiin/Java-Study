package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();

        int H = 0, W = 0;
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];

            char[] directions = { '^', 'v', '<', '>' };
            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };

            int curX = 0, curY = 0;
            int curD = 0;

            // 전차 위치 확인
            for (int i = 0; i < H; i++) {
                String s = in.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == '^' | map[i][j] == 'v' | map[i][j] == '>' | map[i][j] == '<') {
                        curX = i;
                        curY = j;
                        switch (map[i][j]) {
                            case '^':
                                curD = 0;
                                break;
                            case 'v':
                                curD = 1;
                                break;
                            case '<':
                                curD = 2;
                                break;
                            case '>':
                                curD = 3;
                                break;
                        }
                    }
                }

            }

            int COMMAND_CNT = Integer.parseInt(in.readLine());
            String COMMAND = in.readLine();
            int nx = 0, ny = 0;
            for (int i = 0; i < COMMAND_CNT; i++) {
                char cmd = COMMAND.charAt(i);
                if (cmd == 'S') {
                    switch (directions[curD]) {
                        case '^':
                            for (int j = curX; j >= 0; j--) {
                                if (map[j][curY] == '#') {
                                    break;
                                }
                                if (map[j][curY] == '*') {
                                    map[j][curY] = '.';
                                    break;
                                }
                            }
                            break;
                        case 'v':
                            for (int j = curX; j < H; j++) {
                                if (map[j][curY] == '#') {
                                    break;
                                }
                                if (map[j][curY] == '*') {
                                    map[j][curY] = '.';
                                    break;
                                }
                            }
                            break;
                        case '<':
                            for (int j = curY; j >= 0; j--) {
                                if (map[curX][j] == '#') {
                                    break;
                                }
                                if (map[curX][j] == '*') {
                                    map[curX][j] = '.';
                                    break;
                                }
                            }
                            break;
                        case '>':
                            for (int j = curY; j < W; j++) {
                                if (map[curX][j] == '#') {
                                    break;
                                }
                                if (map[curX][j] == '*') {
                                    map[curX][j] = '.';
                                    break;
                                }
                            }
                            break;
                    }
                } else {
                    switch (cmd) {
                        case 'U':
                            curD = 0;
                            break;
                        case 'D':
                            curD = 1;
                            break;
                        case 'L':
                            curD = 2;
                            break;
                        case 'R':
                            curD = 3;
                            break;
                    }
                    nx = curX + dx[curD];
                    ny = curY + dy[curD];

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] != '.') {
                        map[curX][curY] = directions[curD];
                    } else {
                        map[curX][curY] = '.';
                        curX = nx;
                        curY = ny;
                        map[curX][curY] = directions[curD];
                    }
                }
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }
}
