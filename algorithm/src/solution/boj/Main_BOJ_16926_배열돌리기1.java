package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기1 {

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); // 회전 수

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int temp = 0; // 배열의 첫번째 숫자 저장
        int cnt = Math.min(N, M) / 2; // 배열 안에서 돌아야 하는 횟수

        for (int r = 0; r < R; r++) {
            for (int i = 0; i < cnt; i++) {
                temp = arr[i][i];

                // 윗줄 회전
                for (int j = i; j < M - 1 - i; j++) {
                    arr[i][j] = arr[i][j + 1];
                }

                // 오른쪽줄 회전
                for (int j = i; j < N - 1 - i; j++) {
                    arr[j][M - 1 - i] = arr[j + 1][M - 1 - i];
                }

                // 아래줄 회전
                for (int j = M - 1 - i; j > i; j--) {
                    arr[N - 1 - i][j] = arr[N - 1 - i][j - 1];
                }

                // 왼쪽줄 회전
                for (int j = N - 1 - i; j > i; j--) {
                    arr[j][i] = arr[j - 1][i];
                }

                arr[i + 1][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}