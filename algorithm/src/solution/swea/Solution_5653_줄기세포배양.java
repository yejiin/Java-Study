package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {

    static int LEN = 350;  // 주어진 범위에서 만들 수 있는 최대 격자 크기

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[LEN][LEN];
            int startX = (LEN - N) / 2;
            int startY = (LEN - M) / 2;

            List<Cell> liveCells = new ArrayList<>();

            for (int i = startX; i < startX + N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = startY; j < startY + M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0)
                        liveCells.add(new Cell(i, j, map[i][j], false, map[i][j]));
                }
            }

            for (int i = 0; i < K; i++) {
                Collections.sort(liveCells);  // 비활성 -> 생명력 높은 세포 순으로 정렬 (생명력이 높은 세포 먼저 번식하면 다음에 같은 위치에 번식하려는 세포는 번식하지 못함)
                liveCells = multiplyCell(liveCells, map);
            }
            sb.append("#").append(tc).append(" ").append(liveCells.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static List<Cell> multiplyCell(List<Cell> liveCells, int[][] map) {
        List<Cell> newLiveCells = new ArrayList<>();

        for (Cell curCell : liveCells) {
            if (!curCell.isActive) {  // 비활성 상태일 때
                if (curCell.remainLife == 1)  // 활성 상태로 전환
                    newLiveCells.add(new Cell(curCell.x, curCell.y, curCell.life, true, curCell.life));
                else
                    newLiveCells.add(new Cell(curCell.x, curCell.y, curCell.life, false, curCell.remainLife - 1));
            } else { // 활성 상태일 때
                if (curCell.remainLife > 1)
                    newLiveCells.add(new Cell(curCell.x, curCell.y, curCell.life, true, curCell.remainLife - 1));

                for (int d = 0; d < 4; d++) {
                    int nx = curCell.x + dx[d];
                    int ny = curCell.y + dy[d];

                    if (map[nx][ny] > 0) continue; // 죽은 세포가 있는 셀 또는 먼저 번식한 셀에는 번식 안됨

                    map[nx][ny] = curCell.life;
                    newLiveCells.add(new Cell(nx, ny, curCell.life, false, curCell.life));  // 비활성 세포 번식
                }
            }
        }
        return newLiveCells;
    }

    static class Cell implements Comparable<Cell> {
        int x, y, life, remainLife;
        boolean isActive;

        public Cell(int x, int y, int life, boolean isActive, int remainLife) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.isActive = isActive;
            this.remainLife = remainLife;
        }

        @Override
        public int compareTo(Cell o) {
            if (this.isActive == o.isActive)
                return o.life - this.life;
            return Boolean.compare(this.isActive, o.isActive);
        }
    }
}
