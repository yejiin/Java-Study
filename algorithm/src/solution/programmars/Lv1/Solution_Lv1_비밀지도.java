package solution.programmars.Lv1;

public class Solution_Lv1_비밀지도 {

    static int[][] map;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String low = "";
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);

            if (binary.length() < n) {
                for (int j = 0; j < n - binary.length(); j++) {
                    low += "0";
                }
            }

            low += binary;

            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0)
                    map[i][j] = low.charAt(j) - '0';
            }
        }

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String a = "";
            for (int j = 0; j < n; j++) {
                a += map[i][j] == 0 ? " " : "#";
            }

            answer[i] = a;
        }
        return answer;
    }
}
