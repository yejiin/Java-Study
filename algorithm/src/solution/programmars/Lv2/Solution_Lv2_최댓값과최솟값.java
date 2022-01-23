package solution.programmars.Lv2;

import java.util.Arrays;

public class Solution_Lv2_최댓값과최솟값 {

    public String solution(String s) {
        String[] list = s.split(" ");
        int[] numList = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            numList[i] = Integer.parseInt(list[i]);
        }

        Arrays.sort(numList);

        return numList[0] + " " + numList[list.length - 1];
    }
}
