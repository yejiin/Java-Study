package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_14889_스타트와링크 {

    static int N;
    static int[][] graph;
    static boolean[] numbers;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;

        numbers = new boolean[N];

        combination(0, 0);

        System.out.println(result);
    }

    private static void combination(int cnt, int start) {
        if (cnt == N / 2) {
            ArrayList<Integer> teamA = new ArrayList<>();
            ArrayList<Integer> teamB = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (numbers[i])
                    teamA.add(i);
                else
                    teamB.add(i);
            }

            int diff = Math.abs(getSumAbility(teamA) - getSumAbility(teamB));

            result = diff < result ? diff : result;

            return;
        }

        for (int i = start; i < N; i++) {
            numbers[i] = true;
            combination(cnt + 1, i + 1);
            numbers[i] = false;
        }
    }

    private static int getSumAbility(ArrayList<Integer> team) {
        int sum = 0;
        for (int i = 0; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                sum += graph[team.get(i)][team.get(j)] + graph[team.get(j)][team.get(i)];
            }
        }
        return sum;
    }
}
