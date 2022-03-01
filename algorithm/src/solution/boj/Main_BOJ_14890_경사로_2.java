package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행과 열을 바꾼 지도를 하나 더 생성 (중복코드 줄이기 위해)
// 출력 : 지나갈 수 있는 길의 개수
public class Main_BOJ_14890_경사로_2 {

    static int N, L;
    static int[][] mapRow, mapCol;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());  // 2 ~ 100
        L = Integer.parseInt(st.nextToken());  // 1 ~ L

        mapRow = new int[N][N];
        mapCol = new int[N][N];  // mapRow의 행과 열을 바꾼 지도

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                mapRow[i][j] = Integer.parseInt(st.nextToken());
                mapCol[j][i] = mapRow[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            // 가로줄 확인
            if(check(mapRow[i]))
                result++;

            // 세로줄 확인
            if(check(mapCol[i]))
                result++;
        }

        System.out.println(result);
    }

    private static boolean check(int[] row) {

        int[] runway = new int[N]; // 경사로, -2: 오르막, -1: 내리막

        for (int i = 0; i < N - 1; i++) {

            // 경사로 높이 차이가 1이상인 경우 - 예외
            if (Math.abs(row[i] - row[i + 1]) >= 2) {
                return false;
            }

            if (row[i] < row[i + 1])  {  // 다음 칸의 크기가 더 큰 경우
                // 앞의 L만큼 같은 높이인지 확인
                if (!checkFront(row, i + 1, runway)) {
                    return false;
                }
            } else if (row[i] > row[i + 1]) {  // 다음 칸의 크기가 더 작은 경우
                // 뒤의 L만큼 같은 높이인지 확인
                if (!checkBack(row, i, runway)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkFront(int[] row, int y, int[] runway) {

        for (int i = 1; i <= L; i++) {
            if ((y - i) < 0)
                return false;

            // 앞에 있는 길이 높이가 1차이 나는지, 내리막 경사로가 있는지
            if (row[y - i] != (row[y] - 1) || runway[y - i] == -1)
                return false;
            runway[y - i] = -2;  // -2는 오르막 경사로
        }
        return true;
    }

    private static boolean checkBack(int[] row, int y, int[] runway) {

        for (int i = 1; i <= L; i++) {
            if((y + i) >= N)
                return false;

            if (row[y + i] != (row[y] -1) || runway[y + i] == -2)
                return false;
            runway[y + i] = -1;  // -1는 내리막 경사로
        }
        return true;
    }
}