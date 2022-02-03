package solution.programmars.Lv2;

public class Solution_Lv2_이진변환반복하기 {

    public int[] solution(String s) {

        int changeCnt = 0;
        int removedZero = 0;

        while (!s.equals("1")) {
            int cnt = s.length();
            int zero = (int) s.chars().filter(c -> c == '0').count();
            s = Integer.toBinaryString(cnt - zero);

            removedZero += zero;
            changeCnt++;
        }
        return new int[] {changeCnt, removedZero};
    }
}
