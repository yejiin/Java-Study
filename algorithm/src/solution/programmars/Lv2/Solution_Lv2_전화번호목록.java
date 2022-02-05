package solution.programmars.Lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution_Lv2_전화번호목록 {

    public boolean solution(String[] phone_book) {

        // phone_book 문자열 길이별로 오름차순
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        HashSet<String> prefixHash = new HashSet<>();

        int checkedLen = 0;
        for (int i = 0; i < phone_book.length; i++) {

            // 검사하려는 숫자 길이
            int len = phone_book[i].length();

            // 이미 검사한 숫자 길이인지 확인
            if(checkedLen == len)
                continue;

            checkedLen = len;

            prefixHash.clear();

            for (int j = i; j < phone_book.length; j++) {
                String phone = phone_book[j];

                // 검사하려는 숫자 길이가 같다면 prefixHash 에 추가
                if (phone.length() == len) {
                    prefixHash.add(phone);
                    continue;
                }

                String prefix = phone_book[j].substring(0, len);
                if (prefixHash.contains(prefix))
                    return false;
            }
        }
        return true;
    }
}
