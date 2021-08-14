package exhaustive_search;

import java.util.Arrays;

// N개의 서로 다른 수에서 뽑는 순열
public class PermutationTest2 {

    static int N = 3, R = 3;  // nPr, R:뽑는 개수
    static int[] input;
    static int[] numbers;
    static boolean[] isSelected;

    public static void main(String[] args) {

        input = new int[] {1, 2, 4};
        numbers = new int[R];
        isSelected = new boolean[N + 1];

        permutation(0);
    }

    private static void permutation(int cnt) {

        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 가능한 모든 수들이 들어 있는 배열 모든 원소에 대해 시도
        for (int i = 0; i < N; i++) {  // i : 인덱스
            if (isSelected[i])
                continue;  // 인덱스에 해당하는 수가 사용 중인 수면 다음 수로

            numbers[cnt] = input[i];
            isSelected[i] = true;

            permutation(cnt + 1);
            isSelected[i] = false;
        }

    }
}
