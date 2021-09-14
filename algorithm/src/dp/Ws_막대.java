package dp;

public class Ws_막대 {

    public static void main(String[] args) {
        int N = 6;

        int[] D = new int[N + 1];
        D[1] = 2;
        D[2] = 5;

        for (int i = 3; i <= 6; i++) {
            D[i] = D[i - 1] + D[i - 1] + D[i - 2];
        }

        System.out.println(D[N]);
    }
}
