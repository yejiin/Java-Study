package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3 {

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); // 연산 수

        int[][] arr = new int[N][M];
        int[][] curArr;

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        curArr = arr;
        st = new StringTokenizer(in.readLine(), " ");
        // 연산 수행
        for (int d = 0; d < R; d++) {
            int r = Integer.parseInt(st.nextToken());

            switch (r) {
                case 1:
                    curArr = array1(curArr);
                    break;
                case 2:
                    curArr = array2(curArr);
                    break;
                case 3:
                    curArr = array3(curArr);
                    break;
                case 4:
                    curArr = array4(curArr);
                    break;
                case 5:
                    curArr = array5(curArr);
                    break;
                case 6:
                    curArr = array6(curArr);
                    break;
            }
        }
        for (int i = 0; i < curArr.length; i++) {
            for (int j = 0; j < curArr[0].length; j++) {
                sb.append(curArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] array1(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N / 2; i++) {
                int temp = arr[i][j];
                arr[i][j] = arr[N - i - 1][j];
                arr[N - i - 1][j] = temp;
            }
        }
        return arr;
    }

    private static int[][] array2(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = temp;
            }
        }

        return arr;

    }

    private static int[][] array3(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] res = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[j][N - 1 - i] = arr[i][j];
            }
        }

        return res;

    }

    private static int[][] array4(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] res = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[M - 1 - j][i] = arr[i][j];
            }
        }
        return res;
    }

    private static int[][] array5(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int n = N / 2;
        int m = M / 2;

        int[][] res = new int[N][M];
        // 1번
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i][j + m] = arr[i][j];
            }
        }
        // 2번
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i + n][j] = arr[i][j];
            }
        }
        // 3번
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i][j - m] = arr[i][j];
            }
        }
        // 4번
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i - n][j] = arr[i][j];
            }
        }
        return res;
    }

    private static int[][] array6(int[][] arr) {

        int N = arr.length;
        int M = arr[0].length;
        int n = N / 2; // n = 2
        int m = M / 2; // m = 1

        int[][] res = new int[N][M];
        // 1번
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i + n][j] = arr[i][j];
            }
        }
        // 2번
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i][j - m] = arr[i][j];
            }
        }
        // 3번
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                res[i - n][j] = arr[i][j];
            }
        }
        // 4번
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                res[i][m + j] = arr[i][j];
            }
        }
        return res;
    }

}