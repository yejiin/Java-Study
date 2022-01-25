package solution.programmars.Lv2;

public class Solution_Lv2_다음큰숫자 {
    
    public int solution(int n) {
        int cnt = countOne(Integer.toBinaryString(n));

        int comp = n + 1;
        while(true) {

            int compCnt = countOne(Integer.toBinaryString(comp));

            if (cnt == compCnt)
                break;
            comp++;
        }
        return comp;
    }

    private static int countOne(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }
}
