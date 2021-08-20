package backtracking;

import java.util.Scanner;

public class SubSetSumTest {

    static int N, S, totalCnt, totalCnt2;
    static int[] input;
    static boolean[] isSelected;
    static int callCnt, callCnt2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        input = new int[N];
        totalCnt = totalCnt2 = callCnt = callCnt2 = 0;

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        generateSubset(0, 0);
        System.out.println("경우의 수 : " + totalCnt + ", 호출횟수 : " + callCnt);
        generateSubset2(0, 0);
        System.out.println("경우의 수 : " + totalCnt2 + ", 호출횟수 : " + callCnt2);
    }

    // 가지치기 하지 않은 버전
    private static void generateSubset(int cnt, int sum) {

        callCnt++;
        if (cnt == N) {
            if (sum == S) {
                totalCnt++;
                for(int i = 0; i < N; i++) {
                    if (isSelected[i])
                        System.out.println(input[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        isSelected[cnt] = true;
        generateSubset(cnt + 1, sum + input[cnt]);
        isSelected[cnt] = false;
        generateSubset(cnt + 1, sum);
    }

    private static void generateSubset2(int cnt, int sum) {

        callCnt2++;
        if (sum == S) {
            totalCnt2++;
            for (int i = 0; i < N; i++) {
                if (isSelected[i])
                    System.out.println(input[i] + " '");
            }
            System.out.println();
            return;
        }

        // 가지치기 기저조건
        if (sum > S || cnt == N)
            return;

        isSelected[cnt] = true;
        generateSubset(cnt + 1, sum + input[cnt]);
        isSelected[cnt] = false;
        generateSubset(cnt + 1, sum);
    }


}
