package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 방 한 변의 길이 : 4 <= N <= 10
 1 <= 사람의 수 <= 10
 계단의 입구 2개 고정
 계단위에는 동시에 최대 3명까지

 계단 : List<int[]>   x, y, 계단 길이
 사람 : List<int[]>   x, y

 ------------------------------
 1. 조합으로 사람이 이용할 계단 선택
 2. PriorityQueue<int[]>  사람번호, 시간(도착 시간, 내려가고 있는 시간)

 */
public class Solution_2383_점심식사시간 {

    static int result;
    static int[] stairsPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());

            int[][] map = new int[N][N];
            List<int[]> stairs = new ArrayList<>();  // x, y, length
            List<int[]> people = new ArrayList<>();  // x, y
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] > 1) stairs.add(new int[]{i, j, map[i][j]});
                    else if (map[i][j] == 1) people.add(new int[]{i, j});
                }
            }

            result = Integer.MAX_VALUE;
            stairsPeople = new int[people.size()];
            findStairs(0, stairs, people);

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void findStairs(int cnt, List<int[]> stairs, List<int[]> people) {
        if (cnt == people.size()) {
            result = Math.min(result, downStairs(stairsPeople, stairs, people));
            return;
        }

        for (int i = 0; i < 2; i++) {
            stairsPeople[cnt] = i;
            findStairs(cnt + 1, stairs, people);
        }
    }

    private static int downStairs(int[] stairsPeople, List<int[]> stairs, List<int[]> people) {
        int time = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));  // 사람 번호, 거리

        for (int i = 0; i < 2; i++) {
            int[] stair = stairs.get(i);

            for (int j = 0, size = stairsPeople.length; j < size; j++) {
                if (stairsPeople[j] == i)
                    pq.offer(new int[]{j + 1, Math.abs(stair[0] - people.get(j)[0]) + Math.abs(stair[1] - people.get(j)[1])});
            }

            Queue<Integer> q = new LinkedList<>();

            int tmpTime = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (q.size() < 3) {  // 3 보다 작으면 최대 시간 갱신
                    tmpTime = cur[1] + stair[2] + 1;  // 내려가는데 걸린 시간 저장
                } else {  // 처음 도착한 사람이 계단을 빠져나갔는지 확인
                    int first = q.poll();
                    if (first <= cur[1]) tmpTime = cur[1] + stair[2] + 1;  // 빠져나갔다면 바로 계단으로
                    else tmpTime = first + stair[2];   // 첫번째 사람이 나간 시간에 계단 들어감
                }
                q.offer(tmpTime);
            }
            time = Math.max(time, tmpTime);
        }
        return time;
    }
}