package solution.programmars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_Lv2_오픈채팅방 {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    static String ENTER = "Enter";
    static String LEAVE = "Leave";
    static String CHANGE = "Change";
    static String ENTER_MESSAGE = "님이 들어왔습니다.";
    static String LEAVE_MESSAGE = "님이 나갔습니다.";

    public static String[] solution(String[] records) {

        Map<String, String> users = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        String[] answer = new String[list.size()];

        for (String record : records) {
            String[] arr = record.split(" ");
            if (arr[0].equals(ENTER)) {
                users.put(arr[1], arr[2]);
                list.add(new String[] {ENTER, arr[1]});
            } else if (arr[0].equals(LEAVE)) {
                list.add(new String[] {LEAVE, arr[1]});
            } else if (arr[0].equals(CHANGE)) {
                users.put(arr[1], arr[2]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            String message = "";
            String[] cur = list.get(i);
            if (cur[0].equals(ENTER)) {
                message = users.get(cur[1]) + ENTER_MESSAGE;
            } else if (cur[0].equals(LEAVE)) {
                message = users.get(cur[1]) + LEAVE_MESSAGE;
            }
            answer[i] = message;
        }
        return answer;
    }
}
