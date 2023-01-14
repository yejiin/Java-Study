package solution.programmars.Lv2;

import java.util.*;

/**
 * **문제 분석**
 * - 문자열 (loop, index)
 *
 * **문제 풀이**
 * 1. 사전 초기화 Map<String, Integer> → <글자, 색인 번호>
 * 2. message 의 한 글자씩 탐색 (loop)
 *     1. 사전에 포함되지 않은 긴 문자열 찾음
 *     2. 문자열 사전 등록
 *     3. 찾은 문자열의 마지막 문자를 지운 문자열의 색인 번호 출력
 *
 * - 예시) KAKAO
 *     1. K -> KA
 *     2. A -> AK
 *     3. K -> KA -> KAO
 */
public class Solution_Lv2_압축 {

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> dictionary = initDictionary(); // 사전 초기화
        int dicIndex = dictionary.size() + 1;
        int msgLength = msg.length();

        // currentIdx : 현재 글자 첫 문자의 msg index
        // nextIdx : 현재 글자 마지막 문자 한 칸 오른쪽의 msg index
        for (int currentIdx = 0; currentIdx < msgLength; currentIdx++) {
            int nextIdx = currentIdx;
            while (true) {
                nextIdx++;

                if (nextIdx > msgLength) {
                    // 마지막으로 처리되지 않은 글자
                    String lastMsg  = msg.substring(currentIdx, msgLength);
                    answer.add(dictionary.get(lastMsg));
                    break;
                }

                String tempMsg = msg.substring(currentIdx, nextIdx);
                if (!dictionary.containsKey(tempMsg)) {
                    String existMsg = tempMsg.substring(0, tempMsg.length() - 1);
                    answer.add(dictionary.get(existMsg));
                    dictionary.put(tempMsg, dicIndex++);
                    break;
                }
            }
            currentIdx = nextIdx - 2;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private Map<String, Integer> initDictionary() {
        Map<String, Integer> dictionary = new HashMap<>();
        char character = 'A';
        for (int i = 1; i <= 26; i++) {
            dictionary.put(Character.toString(character++), i);
        }
        return dictionary;
    }
}
