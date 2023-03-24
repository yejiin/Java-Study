package solution.programmars.Lv2;

import java.util.*;

public class Solution_Lv2_튜플 {

    public int[] solution(String s) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, int[]> map = new HashMap();

        String numStr = "";
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '}') {
                if (numStr.length() > 0) {
                    queue.add(Integer.parseInt(numStr));
                    numStr = "";
                }

                if (queue.size() == 0) {
                    break;
                }

                int size = queue.size();
                int[] temp = new int[size];
                for (int j = 0; j < size; j++) {
                    temp[j] = queue.poll();
                }
                map.put(size, temp);
            } else if (character >= '0' && character <= '9'){
                numStr += String.valueOf(character - '0');
            } else if (character == ',') {
                if (numStr.length() > 0) {
                    queue.add(Integer.parseInt(numStr));
                    numStr = "";
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            int[] arr = map.get(i);
            for (int j = 0; j < arr.length; j++) {
                if (!answer.contains(arr[j])) {
                    answer.add(arr[j]);
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
