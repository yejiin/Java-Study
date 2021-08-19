package solution.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1 {

    public static void main(String[] args) throws IOException {

//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(in.readLine());
            List<Integer> cryptogram = new ArrayList<>();

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                cryptogram.add(Integer.parseInt(st.nextToken()));
            }

            int commandN = Integer.parseInt(in.readLine());
            int count = 0;
            st = new StringTokenizer(in.readLine(), " ");
            while (count != commandN) {
                String data = st.nextToken();
                if (data.equals("I")) {
                    count++;
                }
                int idx = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                for (int i = 0; i < cnt; i++) {
                    cryptogram.add(idx + i, Integer.parseInt(st.nextToken()));
                }
            }
            sb.append("#").append(tc).append(" ");
            for(int i = 0; i < 10; i++) {
                sb.append(cryptogram.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
