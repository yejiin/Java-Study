package solution.programmars.Lv2;

public class Solution_Lv2_피로도_dfs {

    static int answer;
    static boolean[] isSelected;

    public int solution(int k, int[][] dungeons) {

        isSelected = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return answer;
    }

    static void dfs(int k, int[][] dungeons, int count) {

        for (int i = 0; i < dungeons.length; i++) {

            if (!isSelected[i] && k >= dungeons[i][0]) {
                isSelected[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                isSelected[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}
