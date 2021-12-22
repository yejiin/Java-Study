package solution.programmars.Lv1;

public class Solution_Lv1_시저암호 {

    public static void main(String[] args) {
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            int next = cur + n;

            if (cur == ' ') {
                answer += ' ';
                continue;
            }

            if (cur >= 'a' && cur <= 'z' && next > 'z') {
                next -= ('z' - 'a' + 1);
            } else if (cur >= 'A' && cur <= 'Z' && next > 'Z') {
                next -= ('Z' - 'A' + 1);
            }

            answer += (char) next;
        }
        return answer;
    }
}
