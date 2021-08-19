package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임 {

    static int[] cardGy;
    static int[] cardIy;
    static int[] tempCardIy;
    static boolean[] isSelected;

    static int win;
    static int lose;

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for(int tc = 1; tc <= T; tc++) {
            cardGy = new int[9];
            cardIy = new int[9];
            tempCardIy = new int[9];
            isSelected = new boolean[9];
            win = 0;
            lose = 0;

            boolean[] checkGy = new boolean[19];
            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                cardGy[i] = num;
                checkGy[num] = true;
            }

            int num = 0;
            for (int i = 1; i <19; i++) {
                if(!checkGy[i]) tempCardIy[num++] = i;
            }

            permutation(0);

            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(int cnt) {
        if (cnt == 9) {
            game();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isSelected[i])
                continue;;

            cardIy[cnt] = tempCardIy[i];
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    private static void game() {
        int scoreGy = 0;
        int scoreIy = 0;

        for (int i=0; i<9; i++) {
            int numGy =  cardGy[i];
            int numIy =  cardIy[i];
            int sum = numGy + numIy;
            if (numGy > numIy)
                scoreGy += sum;
            else if (numGy < numIy)
                scoreIy += sum;
        }

        if (scoreGy > scoreIy)
            win++;
        else if (scoreGy < scoreIy)
            lose++;
    }
}
