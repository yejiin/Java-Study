package dp;

public class Ws_아파트 {

    public static void main(String[] args) {
        int N = 8;

        // D[N][0], D[N][1] : N 층에 노랑색을 칠할 수 있는 방법의 수, 파랑색 수
        int[][] D = new int[N + 1][2];
        D[1][0] = 1; // 노랑
        D[1][1] = 1; // 파랑

        for (int i = 2; i <= N; i++) {
            // 노랑은 기존 노랑의 개수에 파랑의 개수를 더함. (노랑 위에 노랑 올라가고, 파랑 위에도 노랑 올라가므로)
            D[i][0] = D[i - 1][0] + D[i - 1][1];
            D[i][1] = D[i - 1][0]; // 파랑은 기존 노랑 위에만 올림
        }
        System.out.println(D[N][0] + D[N][1]);
    }

}
