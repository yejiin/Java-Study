package solution.programmars.Lv1;

public class Solution_Lv1_나머지가1이되는수찾기 {
    
    public int solution(int n) {
        int answer = 0;

        for (int x = 2; x < n; x++) {
            if (n % x == 1) {
                answer = x;
                break;
            }
        }
        return answer;
    }
}
