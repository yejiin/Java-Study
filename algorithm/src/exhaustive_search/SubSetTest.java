package exhaustive_search;

import java.util.Scanner;

public class SubSetTest {

    static int N, totalCnt;
    static int[] input;
    static boolean[] isSelected;  // 부분집합에 포함/비포함 여부를 저장한 배열

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
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
            // 부분집합 완성
            totalCnt++;
            for (int i = 0; i < N; i++) {
                System.out.print((isSelected[i] ? input[i] : "X") + " ");
            }
            System.out.println();

            return;
        }
        // 현재 원소를 부분집합에 넣기
        isSelected[cnt] = true;
        generateSubset(cnt + 1);
        isSelected[cnt] = false;
        generateSubset(cnt + 1);
    }
}
