package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_3040_백설공주와일곱난쟁이 {

    static int N = 7;
    static int[] input;
    static int[] numbers;
    static int[] result;

    public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input_3040.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        input = new int[9];
        numbers = new int[N];
        result = new int[N];
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(in.readLine());
        }
        combination(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }

    // 조합
    private static void combination(int cnt, int start) {

        if (cnt == N) {
            int sum = 0;
            for (int i : numbers) {
                sum += i;
            }
            if (sum == 100) {
                // 합이 100이면 result 배열에 복사
                result = Arrays.copyOf(numbers, numbers.length);
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }

}
