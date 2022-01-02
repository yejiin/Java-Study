package solution.programmars.Lv1;

public class Solution_Lv1_신규아이디추천 {

    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();;
        answer = filter(answer);
        answer = toSingleDot(answer);
        answer = noStartEndDot(answer);
        answer = noBlank(answer);
        answer = noGreaterThan16(answer);
        answer = noLessThan2(answer);

        return answer;
    }

    private static String filter(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        int len = sb.length();

        for (int i = 0; i < len; i++) {
            if (!(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') && !(sb.charAt(i) >= '0' && sb.charAt(i) <= '9') && sb.charAt(i) != '-' && sb.charAt(i) != '_' && sb.charAt(i) != '.') {
                sb.deleteCharAt(i);
                i--;
                len--;
            }
        }
        return sb.toString();
    }

    private static String toSingleDot(String new_id) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder(new_id);
        int len = sb.length();

        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) == '.') {
                if (!flag)
                    flag = true;
                else {
                    sb.deleteCharAt(i);
                    i--;
                    len--;
                }
            } else {
                if (flag)
                    flag = false;
            }
        }
        return sb.toString();
    }

    private static String noStartEndDot(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        if (sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);

        if (sb.length() > 0 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);

        return sb.toString();
    }

    private static String noBlank(String new_id) {

        if (new_id.isEmpty())
            return "a";

        return new_id;
    }

    private static String noGreaterThan16(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);
        if (new_id.length() >= 16)
            sb = new StringBuilder(sb.substring(0, 15));

        if (sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private static String noLessThan2(String new_id) {
        int len = new_id.length();
        char last = new_id.charAt(len - 1);
        StringBuilder sb = new StringBuilder(new_id);

        if (len <= 2) {
            while (sb.length() < 3) {
                sb.append(last);
            }
        }
        return sb.toString();
    }
}
