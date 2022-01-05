package solution.programmars.Lv1;

import java.util.HashSet;

public class Solution_Lv1_폰켓몬 {

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() >= nums.length / 2 ? nums.length / 2 : set.size();
    }
}
