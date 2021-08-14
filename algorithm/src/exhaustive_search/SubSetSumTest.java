package exhaustive_search;

import java.util.Scanner;

public class SubSetSumTest {

    static int N, totalCnt, S;
    static int[] input;
    static boolean[] isSelected;  // 부분집합에 포함/비포함 여부를 저장한 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        totalCnt = 0;

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        generateSubset(0);
        System.out.println("경우의 수 : " + totalCnt);
    }

    private static void generateSubset(int cnt) {  // cnt : 부분집합을 처리하기 위해 고려된 원소 수

        if (cnt == N) {

            // 부분집합의 합을 계산
            int sum = 0;
            for (int i=0; i<N;i++) {
                if (isSelected[i]) sum += input[i];
            }

            // 부분집합의 합 == 목표합 체크
            if (sum == S) {
                totalCnt++;
                for (int i = 0; i < N; i++) {
                    if (isSelected[i]) System.out.print(input[i] + " ");
                }
                System.out.println();
            }
            return;
        }
        // 현재 원소를 부분집합에 넣기
        isSelected[cnt] = true;
        generateSubset(cnt + 1);
        isSelected[cnt] = false;
        generateSubset(cnt + 1);
    }
}
