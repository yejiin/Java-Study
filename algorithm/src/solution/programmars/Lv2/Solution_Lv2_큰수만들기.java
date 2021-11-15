package solution.programmars;


public class Solution_Lv2_큰수만들기 {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        int len = 0;
        int deleteIdx = 0;

        for (int c = 0; c < k; c++) {
            len = sb.length() - 1;
            deleteIdx = len;  // 가장 작은 수가 마지막에 있을 경우

            for (int i = 0; i < len; i++) {
                if (sb.charAt(i) < sb.charAt(i + 1)) {
                    deleteIdx = i;
                    break;
                }
            }
            sb.deleteCharAt(deleteIdx);
        }
        return sb.toString();
    }
}
