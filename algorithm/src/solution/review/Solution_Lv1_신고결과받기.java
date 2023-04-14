package solution.review;

import java.util.*;

public class Solution_Lv1_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<Integer> answer = new ArrayList<>();

        Map<String, List<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        Set<String> reportSet = new HashSet<>();

        for (String id : id_list) {
            reportMap.put(id, new ArrayList<>());
            countMap.put(id, 0);
        }

        for (String r : report) {
            String[] arr = r.split(" ");
            List<String> reportList = reportMap.get(arr[0]);

            if (!reportList.contains(arr[1])) {
                reportList.add(arr[1]);
                reportMap.put(arr[0], reportList);

                int reportCnt = countMap.get(arr[1]) + 1;
                if (reportCnt >= k) {
                    reportSet.add(arr[1]);
                }
                countMap.put(arr[1], reportCnt);
            }
        }

        for (String id : id_list) {
            List<String> reportedId = reportMap.get(id);
            int count = 0;
            for (String r : reportedId) {
                if (reportSet.contains(r)) {
                    count++;
                }
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
