package solution.programmars.Lv2;

import java.util.Arrays;

public class Solution_Lv2_가장큰수 {

    public String solution(int[] numbers) {
        String answer = "";

        String[] numberList = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberList[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberList, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String s : numberList) {
            answer += s;
        }

        // 0이 연속된 경우에는 0을 리턴해야 한다.
        if (numberList[0].equals("0"))
            return "0";

        return answer;
    }
}
