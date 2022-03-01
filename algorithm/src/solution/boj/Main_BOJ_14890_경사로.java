package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 출력 : 지나갈 수 있는 길의 개수
public class Main_BOJ_14890_경사로 {

    static int N, L;
    static int[][] map, mapCol, mapLow;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());  // 2 ~ 100
        L = Integer.parseInt(st.nextToken());  // 1 ~ L

        map = new int[N][N];
        mapLow = new int[N][N];
        mapCol = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            check(i);
        }

        System.out.println(result);
    }

    private static void check(int num) {

        boolean flag = false; // false: 길인 경우
        // 가로줄 확인
        for (int i = 0; i < N - 1; i++) {

            // 경사로 높이 차이가 1이상인 경우 - 예외
            if (Math.abs(map[num][i] - map[num][i + 1]) >= 2) {
                flag = true;
                break;
            }

            if (map[num][i] < map[num][i + 1])  {  // 다음 칸의 크기가 더 큰 경우
                // 앞의 L만큼 같은 높이인지 확인
                if (!checkFront(num, i + 1)) {
                    flag = true;
                    break;
                }
            } else if (map[num][i] > map[num][i + 1]) {  // 다음 칸의 크기가 더 작은 경우
                // 뒤의 L만큼 같은 높이인지 확인
                if (!checkBack(num, i)) {
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) {
            result++;
        }

        boolean flag2 = false;
        // 세로줄 확인
        for (int i = 0; i < N - 1; i++) {

            // 경사로 높이 차이가 1이상인 경우 - 예외
            if (Math.abs(map[i][num] - map[i + 1][num]) >= 2) {
                flag2 = true;
                break;
            }

            if (map[i][num] < map[i + 1][num])  {  // 다음 칸의 크기가 더 큰 경우
                // 위의 L만큼 같은 높이인지 확인
                if (!checkUp(i + 1, num)) {
                    flag2 = true;
                    break;
                }
            } else if (map[i][num] > map[i + 1][num]) {  // 다음 칸의 크기가 더 작은 경우
                // 아래의 L만큼 같은 높이인지 확인
                if (!checkDown(i, num)) {
                    flag2 = true;
                    break;
                }
            }
        }

        if (!flag2) {
            result++;
        }
    }

    private static boolean checkFront(int x, int y) {

        for (int i = 1; i <= L; i++) {
            if ((y - i) < 0)
                return false;

            // 앞에 있는 길이 높이가 1차이 나는지, 내리막 경사로가 있는지
            if (map[x][y - i] != (map[x][y] - 1) || mapLow[x][y - i] == -1)
                return false;
            mapLow[x][y - i] = -2;  // -2는 오르막 경사로
        }
        return true;
    }

    private static boolean checkBack(int x, int y) {

        for (int i = 1; i <= L; i++) {
            if((y + i) >= N)
                return false;

            // 뒤에 있는 길 높이가 1보다 작은지, 오르막 경사로가 있는지
            if (map[x][y + i] != (map[x][y] -1) || mapLow[x][y + i] == -2)
                return false;
            mapLow[x][y + i] = -1;  // -1는 내리막 경사로
        }
        return true;
    }

    private static boolean checkUp(int x, int y) {

        for (int i = 1; i <= L; i++) {
            if ((x - i) < 0)
                return false;

            if (map[x - i][y] != (map[x][y] - 1) || mapCol[x - i][y] == -1)
                return false;
            mapCol[x - i][y] = -2;  // -2은 오르막 경사로
        }
        return true;
    }

    private static boolean checkDown(int x, int y) {

        for (int i = 1; i <= L; i++) {
            if ((x + i) >= N)
                return false;

            if (map[x + i][y] != (map[x][y] - 1) || mapCol[x + i][y] == -2)
                return false;
            mapCol[x + i][y] = -1;  // -1은 내리막 경사로
        }
        return true;
    }
}