package solution.programmars.Lv1;

public class Solution_Lv1_신규아이디추천_정규표현식 {

    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }
    public static String solution(String new_id) {
        String answer = new KakaoId(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();

        return answer;
    }

    private static class KakaoId {
        private String id;

        KakaoId (String id) {
            this.id = id;
        }

        private KakaoId replaceToLowerCase() {
            id = id.toLowerCase();
            return this;
        }

        /*
        [] : 문자의 집합
        [abc] : a, b, c 중의 문자 1개
        [^abc] : a, b, c 를 제외한 문자 1개
        [a-d1-7] : a~d,1~7 사이의 문자 1개
         */
        private KakaoId filter() {
            id = id.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        /*
        {} : 횟수 또는 범위
         */
        private KakaoId toSingleDot() {
            id = id.replaceAll("[.]{2,}", ".");
            return this;
        }

        /*
        ^ : 문자열 시작
        | : or 연산
        & : 문자열 종료
         */
        private KakaoId noStartEndDot() {
            id = id.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KakaoId noBlank() {
            id = id.isEmpty() ? "a" : id;
            return this;
        }

        private KakaoId noGreaterThan16() {
            if (id.length() >= 16) {
                id = id.substring(0, 15);
            }
            id = id.replaceAll("[.]$", "");
            return this;
        }

        private KakaoId noLessThan2() {
            StringBuilder sb = new StringBuilder(id);
            while (sb.length() <= 2) {
                sb.append(sb.charAt(sb.length() - 1));
            }
            id = sb.toString();
            return this;
        }

        private String getResult() {
            return id;
        }
    }
}
