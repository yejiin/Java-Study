package solution.swea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// simulation
public class Solution_4013_특이한자석 {

    static int K;
    static int[][] magnets, rotateInfo;
    static int result;

    static class Magnet {
        int loc, dir;

        public Magnet(int loc, int dir) {
            this.loc = loc;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            K = Integer.parseInt(in.readLine());

            magnets = new int[5][8];
            for (int i = 1; i <= 4; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            rotateInfo = new int[K][2];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < 2; j++) {
                    rotateInfo[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            find();

            result = 0;
            for (int i = 1; i <= 4; i++) {
                if (magnets[i][0] == 1) {
                    result += 1 << (i - 1);
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void find() {

        List<Magnet> findMagnets = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int loc = rotateInfo[i][0];
            int dir = rotateInfo[i][1];
            findMagnets.add(new Magnet(loc, dir));

            int dr = dir;
            for (int j = loc; j < 4; j++) {  // 오른쪽에 있는 자석들 중 회전시킬 자석 찾기
                dr *= (-1);
                if(magnets[j][2] != magnets[j + 1][6]) {
                    findMagnets.add(new Magnet(j + 1, dr));
                } else {
                    break;
                }
            }

            int dl = dir;
            for (int j = loc; j > 1; j--) {  // 왼쪽에 있는 자석들 중 회전시킬 자석 찾기
                dl *= (-1);
                if(magnets[j][6] != magnets[j -1][2]) {
                    findMagnets.add(new Magnet(j - 1, dl));
                } else {
                    break;
                }
            }
            rotate(findMagnets);
            findMagnets.clear();
        }
    }

    private static void rotate(List<Magnet> findMagnets) {
        for (Magnet findMagnet : findMagnets) {
            int loc = findMagnet.loc;
            int dir = findMagnet.dir;

            if (dir == 1) {
                int temp = magnets[loc][7];
                for (int i = 7; i > 0; i--) {
                    magnets[loc][i] = magnets[loc][i - 1];
                }
                magnets[loc][0] = temp;
            } else {
                int temp = magnets[loc][0];
                for (int i = 1; i < 8; i++) {
                    magnets[loc][i - 1] = magnets[loc][i];
                }
                magnets[loc][7] = temp;
            }
        }
    }
}
