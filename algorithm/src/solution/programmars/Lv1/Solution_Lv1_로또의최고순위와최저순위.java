package solution.programmars.Lv1;

import java.util.Arrays;

public class Solution_Lv1_로또의최고순위와최저순위 {

    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0;
        int matchCnt = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for (int i = lottos.length - 1; i >= 0; i--) {

            if (lottos[i] == 0) {
                zeroCnt = i + 1;
                break;
            }

            for (int j = win_nums.length - 1; j >= 0; j--) {
                if (win_nums[j] == lottos[i])
                    matchCnt++;
            }
        }
        int[] answer = {countRank(zeroCnt + matchCnt), countRank(matchCnt)};
        return answer;
    }

    private static int countRank(int cnt) {
        return cnt >= 2 ? 7 - cnt : 6;
    }
}
