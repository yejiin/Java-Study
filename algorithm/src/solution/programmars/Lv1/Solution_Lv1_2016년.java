package solution.programmars.Lv1;

public class Solution_Lv1_2016년 {

    static String[] dayName = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    static int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public String solution(int a, int b) {

        int dSum = 0;

        for (int i = 1; i < a; i++) {
            dSum += days[i];
        }

        dSum += b;
        return dayName[dSum % 7];
    }
}
