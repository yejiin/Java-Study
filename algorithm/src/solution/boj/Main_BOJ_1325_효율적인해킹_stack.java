package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. N개의 컴퓨터로 이루어진 회사
 * 2. 한 번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있는 컴퓨터 해킹
 * 3. A가 B를 신뢰(A B) -> B를 해킹하면 A도 해킹 가능
 *
 * input: N번의 번호, M개의 신뢰 관계 <= 10,000
 * return : 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호를 오름차순으로
 *
 *
 * 풀이)
 * - result -> List<Integer> 오름차순 sort
 * 1. A B 관계일 때 B 리스트에 A 저장
 * 2. 컴퓨터 1번 부터 깊이 우선 탐색(stack 사용)
 *      2-1. 해킹 가능한 컴퓨터의 수는 count 변수에 저장
 *      2-2. n번 컴퓨터의 해킹 가능한 컴퓨터 수가 count보다 크면 count에 저장 및 list reset 후 번호 저장
 *      2-3. count 변수와 같으면 list에 추가
 */
public class Main_BOJ_1325_효율적인해킹_stack {

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] relation = new List[N];
        for (int i = 0; i < N; i++) {
            relation[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (!relation[b].contains(a)) {
                relation[b].add(a);
            }
        }

        int maxCount = 0;
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int count = dfs(i, relation);
            if (maxCount < count) {
                maxCount = count;
                maxList.clear();
                maxList.add(i);
            } else if (maxCount == count) {
                maxList.add(i);
            }
        }

        Collections.sort(maxList);
        for (Integer maxNum : maxList) {
            System.out.print(maxNum + 1 + " ");
        }
    }

    private static int dfs(int num, List<Integer>[] relation) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];

        stack.push(num);
        visited[num] = true;

        int count = 1;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int r : relation[cur]) {
                if (!visited[r]) {
                    stack.push(r);
                    visited[r] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
