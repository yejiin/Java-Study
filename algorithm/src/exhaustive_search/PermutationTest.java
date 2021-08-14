package exhaustive_search;

import java.util.Arrays;

// 1, 2, 3 순열
public class PermutationTest {

    static int N = 3, R = 3;
    static int[] numbers;  // 순열 저장 배열
    static boolean[] isSelected;  // 인덱스에 해당하는 숫자가 사용 중인지 저장하는 배열

    public static void main(String[] args) {

        numbers = new int[R];
        isSelected = new boolean[N + 1];

        permutation(0);
    }

    private static void permutation(int cnt) {  // cnt : 현재까지 뽑은 순열 수의 개수

        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 가능한 모든 수 시도
        for (int i = 1; i <= N; i++) {
            if (isSelected[i])
                continue;  // 사용 중인 수면 다음 수로

            numbers[cnt] = i;
            isSelected[i] = true;

            // 다음 자리 순열 뽑기
            permutation(cnt + 1);
            isSelected[i] = false;  // ex) 두번째 자리에 2말고 3을 넣어보기 위해
        }

    }
}
