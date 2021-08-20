package divide_and_conquer;

public class MakeSpaceTest {

    static int white, green;
    static int[][] spaces;

    public static void main(String[] args) {

        int n = 8;
        spaces = new int[][]{
                {1, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1}};

        cut(0, 0, n);
        System.out.println(white);
        System.out.println(green);
    }

    // 1. 같은 색인지 체크
    // 2. 같은 색이 아니면 4분할
    private static void cut(int r, int c, int size) {

        int sum = 0;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
               sum += spaces[i][j];
            }
        }

        // 같은 색인지 체크(기저 조건)
        if (sum == size * size) {  // 초록색
            green++;
        } else if (sum == 0) {  // 하얀색
            white++;
        } else {  // 색이 섞여 있음(유도 조건)

            // 4분할하여 각각의 사각형 처리
            int half = size / 2;

            cut(r, c, half);
            cut(r, c + half, half);
            cut(r + half, c, half);
            cut(r + half, c + half, half);
        }
    }
}
