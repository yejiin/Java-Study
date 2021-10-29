package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_17143_낚시왕 {

    static class Shark implements Comparable<Shark> {
        int r, c, s, d, z;  // (r, c): 상어의 위치, s: 속력, d: 이동방향, z: 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.c == o.c)
                return this.r - o.r;
            return this.c - o.c;
        }
    }

    private static int R, C, M;
    private static ArrayList<Shark> sharkList;
    private static Shark[][] sharkMap;
    private static int result;

    private static int[] dr = {0, -1, 1, 0, 0};
    private static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());  // 상어수

        sharkList = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d <= 2)
                s = s % ((R - 1) * 2);  // (R-1)*2 반복 주기
            else if (d > 2)
                s = s % ((C - 1) * 2);

            Shark shark = new Shark(r, c, s, d, z);
            sharkList.add(shark);
        }

        for (int m = 1; m <= C; m++) {  // 낚시왕 위치

            Collections.sort(sharkList);

            for (int i = 0; i < sharkList.size(); i++) {

                Shark cur = sharkList.get(i);

                // 낚시왕이 상어를 잡았을 때. 상어 크기 합치기, 리스트에서 제외
                if (m == cur.c) {
                    result += cur.z;
                    sharkList.remove(i);
                    break;
                }
            }
            sharkMove(); // 상어 이동

            sharkMap = new Shark[R + 1][C + 1];
            checkEating();
        }
        System.out.println(result);
    }

    private static void checkEating() {

        for (int i = 0; i < sharkList.size(); i++) {
            int r = sharkList.get(i).r;
            int c = sharkList.get(i).c;

            if (sharkMap[r][c] == null)
                sharkMap[r][c] = sharkList.get(i);
            else {
                if (sharkMap[r][c].z < sharkList.get(i).z) {
                    sharkMap[r][c] = sharkList.get(i);
                }
            }
        }

        sharkList.clear();

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (sharkMap[r][c] != null) {
                    sharkList.add(new Shark(sharkMap[r][c].r, sharkMap[r][c].c, sharkMap[r][c].s, sharkMap[r][c].d, sharkMap[r][c].z));
                }
            }
        }
    }


    private static void sharkMove() {

        for (int j = 0; j < sharkList.size(); j++) {
            Shark shark = sharkList.get(j);

            for (int i = 0; i < shark.s; i++) {
                shark.r = shark.r + dr[shark.d];
                shark.c = shark.c + dc[shark.d];

                if (shark.r <= 0 || shark.r > R || shark.c <= 0 || shark.c > C) {

                    shark.r -= dr[shark.d];
                    shark.c -= dc[shark.d];

                    if (shark.d == 1)
                        shark.d = 2;
                    else if (shark.d == 2)
                        shark.d = 1;
                    else if (shark.d == 3)
                        shark.d = 4;
                    else if (shark.d == 4)
                        shark.d = 3;
                    i--;
                }
            }
        }
    }
}
