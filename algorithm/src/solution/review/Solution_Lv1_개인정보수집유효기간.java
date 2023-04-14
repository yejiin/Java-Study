package solution.review;

import java.util.*;

public class Solution_Lv1_개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        long todayInt = dateToInt(today);

        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] arr = term.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] arr = privacy.split(" ");
            long dateInt = dateToInt(arr[0]);
            if (dateInt + (termMap.get(arr[1]) * 28) <= todayInt) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private long dateToInt(String date) {
        String[] arr = date.split("\\.");
        return Integer.parseInt(arr[0]) * 28 * 12
                + Integer.parseInt(arr[1]) * 28
                + Integer.parseInt(arr[2]);
    }
}