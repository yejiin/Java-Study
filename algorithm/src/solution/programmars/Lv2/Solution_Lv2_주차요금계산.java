package solution.programmars.Lv2;

import java.util.*;

public class Solution_Lv2_주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        int finishTime = 23 * 60 + 59;

        Map<String, int[]> parkingTime = new HashMap<>();  // <차량 번호, [입차 시간, 출차 시간]>
        Map<String, Integer> diffTime = new HashMap<>();  // <차량 번호, 주차 시간 간격>
        Map<String, Integer> parkingFee = new HashMap<>();   // <차량 번호, 요금>

        for (String record : records) {
            String[] recordInfo = record.split(" ");

            if (recordInfo[2].equals("IN")) {
                parkingTime.put(recordInfo[1], new int[]{timeToMinute(recordInfo[0]), 0});
            } else {
                int[] time = parkingTime.get(recordInfo[1]);
                time[1] = timeToMinute(recordInfo[0]);

                diffTime.put(recordInfo[1], diffTime.getOrDefault(recordInfo[1], 0) + (time[1] - time[0]));
            }
        }

        for (String key : parkingTime.keySet()) {
            int[] times = parkingTime.get(key);
            if (times[1] == 0) {
                diffTime.put(key, diffTime.getOrDefault(key, 0) + (finishTime - times[0]));
            }
        }

        for (String key : diffTime.keySet()) {
            if (diffTime.get(key) <= fees[0]) {
                parkingFee.put(key, fees[1]);
            } else {
                double d = fees[2];
                parkingFee.put(key, fees[1] + (int) (Math.ceil((diffTime.get(key) -  fees[0]) / d)) * fees[3]);
            }
        }

        List<String> keySet = new ArrayList<>(parkingFee.keySet());
        Collections.sort(keySet);

        int[] answer = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            answer[i] = parkingFee.get(keySet.get(i));
        }

        return answer;
    }

    public int timeToMinute(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}
