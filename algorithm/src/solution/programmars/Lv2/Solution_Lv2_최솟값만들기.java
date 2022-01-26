package solution.programmars.Lv2;

import java.util.Arrays;

public class Solution_Lv2_최솟값만들기 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;
        for (int i = 0; i < len; i++) {
            answer += A[i] * B[len - 1 - i];
        }
        return answer;
    }
}
