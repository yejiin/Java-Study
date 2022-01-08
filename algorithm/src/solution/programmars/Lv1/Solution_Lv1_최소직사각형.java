package solution.programmars.Lv1;

public class Solution_Lv1_최소직사각형 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
    }

    public static int solution(int[][] sizes) {
        int width = sizes[0][0];
        int height = sizes[0][1];

        for (int i = 1; i < sizes.length; i++) {
            int w1 = Math.max(width, sizes[i][0]);
            int h1 = Math.max(height, sizes[i][1]);

            int w2 = Math.max(width, sizes[i][1]);
            int h2 = Math.max(height, sizes[i][0]);

            if (w1 * h1 < w2 * h2) {
                width = w1;
                height = h1;
            } else {
                width = w2;
                height = h2;
            }
        }
        return width * height;
    }
}
