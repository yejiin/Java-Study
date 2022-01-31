package solution.programmars.Lv2;

public class Solution_Lv2_피로도_permutation {

    static int N, answer;
    static boolean[] isSelected;
    static int[] order;

    public int solution(int k, int[][] dungeons) {

        N = dungeons.length;

        isSelected = new boolean[N];
        order = new int[N];

        permutation(0, k, dungeons);

        return answer;
    }

    static void permutation(int cnt, int k, int[][] dungeons) {

        if (cnt == N) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                int cur = order[i];

                if (dungeons[cur][0] <= k) {
                    count++;
                    k -= dungeons[cur][1];
                } else {
                    break;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i])
                continue;

            order[cnt] = i;
            isSelected[i] = true;

            permutation(cnt + 1, k, dungeons);
            isSelected[i] = false;
        }
    }
}
