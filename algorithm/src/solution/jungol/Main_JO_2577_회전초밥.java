package solution.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 15961 회전 초밥
public class Main_JO_2577_회전초밥 {

    static int N, D, K, C;
    static int[] dish;
    static int[] sushi;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken()); // 접시의 수
        D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        dish = new int[N]; // 접시위에 초밥의 종류
        sushi = new int[D + 1]; // 손님이 초밥의 종류별로 먹었던 개수

        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(in.readLine());
        }

        System.out.println(countSushi());

    }

    private static int countSushi() {

        int maxCnt = 0; // 초밥 가짓수의 최댓값
        boolean coupon = false; // 쿠폰 초밥을 먹었는지 안먹었는지
        int cnt = 0; // 손님이 먹은 중복되지 않은 초밥 개수

        for (int i = 0; i < K; i++) { // 첫번째 접시부터 K개 까지 먹었을 때

            if (sushi[dish[i]] == 0) // 전에 해당 초밥을 먹어보지 않았을 때
                cnt++; //

            sushi[dish[i]]++; // 먹은 초밥 기록
        }

        maxCnt = cnt;

        if (sushi[C] > 0) // 쿠폰의 초밥을 먹었을 경우
            coupon = true;

        int i = 0, j = K; // 손님이 K개씩 먹을 때, i: 맨 처음에 먹은 접시, j: K + 1 번째 접시
        for (; i < N; i++, j++) {
            if (i >= N - K && j >= N) // j가 N개를 넘어갈 때, 다시 첫번째 접시로
                j = j - N;

            if (--sushi[dish[i]] == 0) // i번째 접시의 초밥을 먹은 초밥에서 뺌. 해당 초밥을 먹은 적이 없다면 초밥 가짓수에서 제외
                --cnt;

            if (++sushi[dish[j]] == 1) // j번째 접시의 초밥을 먹은 초밥에 더함. 해당 초밥을 처음 먹는다면 초밥 가짓수에 추가
                ++cnt;

            if (maxCnt < cnt) { // 초밥 최대값의 갱신이 일어날 때
                maxCnt = cnt;

                if (sushi[C] > 0) // 쿠폰 초밥을 먹은적이 있다면
                    coupon = true;
                else if (sushi[C] == 0) // 쿠폰 초밥을 안먹었다면
                    coupon = false;

            } else if (maxCnt == cnt) {
                if (sushi[C] == 0) // 쿠폰 초밥을 안먹었을 경우를 우선으로
                    coupon = false;
            }
        }

        if (coupon)
            return maxCnt;
        else
            return maxCnt + 1;
    }
}
