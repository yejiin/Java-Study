package exhaustive_search;

import java.util.Arrays;

// N개의 서로 다른 수 R개 뽑는 조합
public class CombinationTest {

    static int N = 3, R = 2;
    static int[] input;
    static int[] numbers;

    public static void main(String[] args) {

        input = new int[] {1, 4, 7};
        numbers = new int[R];

        combination(0, 0);
    }

    private static void combination(int cnt, int start) {  // cnt:현재까지 뽑은 조합 원소 개수, start:조합 시도할 원소의 시작 인덱스

        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // start 위치의 수부터 가능한 수 모두 고려
        for (int i = start; i < N; i++) {  // i : 인덱스
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }
}
