package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {  //배열 초기화
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());

            arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;

        int min = 0, current = 0;
        for (int i = 0; i < N; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && distance[j] < min) {
                    current = j;
                    min = distance[j];
                }
            }

            if (min > K)  // 거리가 K보다 큰 정점에 대해서는 더 이상 거리 계산을 하지 않음
                break;

            visited[current] = true;


            for (int j = 0; j < arr[current].size(); j++) {
                int idx = arr[current].get(j);
                if (!visited[idx] && distance[idx] > distance[current] + 1)
                    distance[idx] = distance[current] + 1;
            }

        }

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                flag = true;
                System.out.println(i);
            }
        }

        if (!flag)
            System.out.println(-1);
    }
}
