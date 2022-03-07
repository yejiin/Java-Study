package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

// 출력 : A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간
public class Main_BOJ_17140_이차원배열과연산 {

    static int r, c;
    static int[][] graph;
    static int rSize, cSize;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        r = Integer.parseInt(st.nextToken());  // 1 <= r, c, k <= 100
        c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[101][101];

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 1; j <= 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rSize = 3;
        cSize = 3;

        // 0초일 때
        if (graph[r][c] == k) {
            System.out.println(0);
            return;
        }

        // 1초부터 100초까지 연산
        for (int i = 1; i <= 100; i++) {
            if (calc() == k) {
                System.out.println(i);
                return;
            }
        }

        // 100초가 지났을 경우
        System.out.println(-1);
    }

    private static int calc() {
        int cs = 0, rs = 0;  // 연산 후 변경된 열 크기, 행 크기
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        if (rSize >= cSize) {
            for (int i = 1; i <= rSize; i++) {
                for (int j = 1; j <= cSize; j++) {
                    int key = graph[i][j];
                    if (key != 0)
                        hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
                }

                // 정렬
                List<Entry<Integer, Integer>> list = sortHashMap(hashMap);
                hashMap.clear();

                int j = 1;
                for (; j <= list.size(); j++) {
                    graph[i][j * 2 - 1] = list.get(j - 1).getKey();
                    graph[i][j * 2] = list.get(j - 1).getValue();
                }

                // 정렬된 결과를 graph 에 넣고 이전 데이터가 남아있는 경우 0으로
                j = list.size() * 2 + 1;
                for (; j <= cSize; j++) {
                    graph[i][j] = 0;
                }

                // 열의 크기가 가장 큰 열 구하기
                cs = list.size() * 2 > cs ? list.size() * 2 : cs;
            }
            cSize = cs;
        } else {
            for (int i = 1; i <= cSize; i++) {
                for (int j = 1; j <= rSize; j++) {
                    int key = graph[j][i];
                    if (key != 0)
                        hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
                }

                // 정렬
                List<Entry<Integer, Integer>> list = sortHashMap(hashMap);
                hashMap.clear();

                int j = 1;
                for (; j <= list.size(); j++) {
                    graph[j * 2 - 1][i] = list.get(j - 1).getKey();
                    graph[j * 2][i] = list.get(j - 1).getValue();
                }

                // 정렬된 결과를 graph 에 넣고 이전 데이터가 남아있는 경우 0으로
                j = list.size() * 2 + 1;
                for (; j <= rSize; j++) {
                    graph[j][i] = 0;
                }

                // 행의 크기가 가장 큰 행 구하기
                rs = list.size() * 2 > rs ? list.size() * 2 : rs;
            }
            rSize = rs;
        }

        return graph[r][c];
    }

    // Map Entry 을 리스트에 넣고 정렬
    private static List<Entry<Integer, Integer>> sortHashMap(HashMap<Integer, Integer> hashMap) {

        List<Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());

        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue())
                return o1.getKey() - o2.getKey();
            return o1.getValue() - o2.getValue();
        });

        return list;
    }
}
