package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 출력 : 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형의 개수
public class Main_BOJ_15685_드래곤커브 {

    static int N;
    static int[][] data; // 입력 데이터
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] rotate = {1, 2, 3, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(in.readLine()); // 드래곤 커브의 개수
        data = new int[N][4];
        graph = new int[101][101];

        // x, y: 드래곤 커브의 시작점, d: 시작 방향, g: 세대
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            data[i] = new int[]{x, y, d, g};
        }

        for (int i = 0; i < N; i++) {
            makeDragonCurve(data[i]);
        }
        System.out.println(countSquare());
    }

    private static void makeDragonCurve(int[] data) {

        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(data[2]); // 첫번째 방향 저장

        // g(세대)번 만큼 반복
        for (int i = 0; i < data[3]; i++) {
            int cnt = directions.size();
            // 방향 저장 리스트에서 최근에 저장된 방향부터 90도 회전 후 저장
            for (int j = cnt - 1; j >= 0; j--) {
                directions.add(rotate[directions.get(j)]);
            }
        }

        // 그래프에 드래곤 커브 입력
        int x = data[0];
        int y = data[1];
        graph[x][y] = 1;

        for (Integer d : directions) {
            x += dx[d];
            y += dy[d];
            graph[x][y] = 1;
        }
    }

    // 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형 개수 구하기
    private static int countSquare() {
        int cnt = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (graph[i][j] == 1 && graph[i + 1][j] == 1 && graph[i][j + 1] == 1 && graph[i + 1][j + 1] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}
