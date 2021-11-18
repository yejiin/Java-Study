package solution.programmars.Lv1;

public class Solution_Lv1_숫자문자열과영단어 {

    public int solution(String s) {
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replace(alphabet[i], number[i]);
        }
        return Integer.parseInt(s);
    }
}
