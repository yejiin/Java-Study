package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 6 <= N <= 20
 경사로 높이 1, 2 <= X <= 4
 동일한 셀에 두 개 이상의 경사로 X

 출력: 활주로를 건설할 수 있는 경우의 수

 1. 세로 확인
 2. 가로 확인
 3. 같은 숫자 세기(num, cnt)
 4. if num 보다 1 높은 지형 만나면 cnt가 x보다 크거나 같을 때 가능
 5. else if num 보다 1 낮은 지형 만나면 x만큼 1 낮은 지형이 있는지 확인 -> for문의 i 패쓰
 */
public class Solution_SWEA_4014_활주로건설 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            int[][] rMap = new int[N][N];  // row, col 전환

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    rMap[j][i] = map[i][j];
                }
            }

            int result = 0;
            result += check(map, N, X);  // 가로줄 확인
            result += check(rMap, N, X);  // 세로줄 확인

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int check(int[][] map, int N, int X) {

        int count = 0;

        for (int i = 0; i < N; i++) {

            boolean flag = true;
            int num = map[i][0];
            int cnt = 1;
            for (int j = 1; j < N; j++) {

                if (Math.abs(num - map[i][j]) > 1) {  // 높이 차이가 1보다 크면 불가능
                    flag = false;
                    break;
                }

                if (num == map[i][j]) {
                    cnt++;
                } else if (num < map[i][j] ) {  // 1 높은 지형 만나면
                    if (cnt < X) {
                        flag = false;
                        break;
                    }
                    num = map[i][j];
                    cnt = 1;
                } else {  // 1 작은 지형 만나면
                    if (j + X - 1 >= N) {  // 활주로가 N의 범위를 넘어가면
                        flag = false;
                        break;
                    }

                    int len = 0;
                    for (int k = 0; k < X; k++) {
                        if (map[i][j + k] == map[i][j])
                            ++len;
                    }

                    if (len < X) {
                        flag = false;
                        break;
                    }
                    num = map[i][j];
                    j += len - 1;
                    cnt = 0;
                }
            }

            if (flag)
                count++;
        }
        return count;
    }
}
