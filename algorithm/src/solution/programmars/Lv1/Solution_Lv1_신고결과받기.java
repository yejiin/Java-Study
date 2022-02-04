package solution.programmars.Lv1;

import java.util.*;

public class Solution_Lv1_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {

        int id_list_len = id_list.length;

        int[] answer = new int[id_list_len];
        int[] reportCnt = new int[id_list_len];
        Map<String, Integer> id_map = new HashMap<>();
        Set<String>[] report_list = new Set[id_list_len];

        for (int i = 0; i < id_list_len; i++) {
            report_list[i] = new HashSet<>();
        }

        for (int i = 0; i < id_list_len; i++) {
            id_map.put(id_list[i], i);
        }


        for (int i = 0; i < report.length; i++) {
            String[] cur = report[i].split(" ");
            String reporter = cur[0];
            String reported = cur[1];

            if(report_list[id_map.get(reporter)].add(reported))
                reportCnt[id_map.get(reported)]++;
        }

        for (int i = 0; i < id_list_len; i++) {
            int cnt = 0;

            for (String reported_id : report_list[i]) {
                if (reportCnt[id_map.get(reported_id)] >= k)
                    cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}