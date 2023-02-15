package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 풀이)
 * 1. A B 관계일 때 A 리스트에 B 저장
 * 2. 컴퓨터 1번 부터 깊이 우선 탐색(재귀 사용)
 *      2-1. n번 컴퓨터와 신뢰하는 관계일 경우 신뢰하는 관계의 번호의 count 배열의 수를 1 더해줌
 * 3. count의 값이 가장 큰 번호 출력
 */
public class Main_BOJ_1325_효율적인해킹_recursion {

    private static int N;
    private static int M;

    private static List<Integer>[] relation;
    private static boolean[] visited;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relation = new List[N];
        for (int i = 0; i < N; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            relation[a].add(b);
        }

        count = new int[N];
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }

        for (int i = 0; i < N; i++) {
            if (max == count[i])
                System.out.print(i + 1 + " ");
        }
    }

    private static void dfs(int cur) {
        for (int next : relation[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                count[next]++;
                dfs(next);
            }
        }
    }
}
