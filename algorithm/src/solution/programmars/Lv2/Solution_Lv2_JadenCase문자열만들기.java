package solution.programmars.Lv2;

public class Solution_Lv2_JadenCase문자열만들기 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        char start = s.charAt(0);
        if (start >= 'a' && start <= 'z')
            start -= 32;
        sb.append(start);

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i - 1) == ' ') {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z')
                    c -= 32;
                sb.append(c);
            } else {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'Z')
                    c += 32;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
