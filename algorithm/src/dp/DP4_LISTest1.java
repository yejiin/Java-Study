package dp;

// O(n^2)
import java.util.Scanner;

public class DP4_LISTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] LIS = new int[N]; // 각 원소를 끝으로 하는 최장거리

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;  // 전체 중의 최대 길이
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;

            for (int j = 0; j < i; j++) {  // j : i의 앞쪽 원소
               if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1)
                   LIS[i] = LIS[j] + 1;
            } // i를 끝으로 하는 최장 길이 값 계산 완료

            if (max < LIS[i])
                max = LIS[i];
        }
        System.out.println(max);
    }
}
