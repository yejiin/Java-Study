package array;

public class ArrayTest {

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15 ,16}};

        int R = arr.length;
        int C = arr[0].length;

        // 행 우선 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // 열 우선 탐색
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // 지그재그 순회
        for (int i = 0; i < R; i++) {
            for (int j = 0 ;j < C; j++) {
                int temp = (i%2 == 0) ? j : C - 1 - j;
                System.out.print(arr[i][temp] + " ");
            }
            System.out.println();
        }

        // 2차 배열의 한 좌표에서 4방향 인접 배열 요소 탐색
        int[] dr = {-1, 1, 0, 0};  // 상하좌우
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                        continue;
//                    arr[nr][nc];
                }
            }
        }
    }
}
