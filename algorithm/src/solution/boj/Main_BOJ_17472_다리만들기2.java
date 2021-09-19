package solution.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17472_다리만들기2 {

    static int N, M;
    static int islandCnt; // 섬의 개수 + 1
    static int count; // 다리 길이 저장 변수
    static int[][] map;
    static int[][] arr; // 섬마다 다른 섬까지 다리 길이 저장
    static ArrayList<int[]> list; // 섬 리스트. 섬의 맨처음 좌표 저장

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num == 1 ? -1 : num;
            }
        }

        islandCnt = 1;
        numberingMap(); // 섬마다 번호매김 (섬의 번호는 1부터 시작)

        arr = new int[islandCnt][islandCnt]; // 최소 다리 길이를 저장할 배열을 최대값으로 최기화
        for (int i = 1; i < islandCnt; i++) {
            Arrays.fill(arr[i], 1, islandCnt, Integer.MAX_VALUE);
        }

        calcDistance(); // 최소 다리 길이 저장

        System.out.println(getBridgeLen());
    }

    // prim
    private static int getBridgeLen() {
        boolean[] visited = new boolean[islandCnt];
        int[] minEdge = new int[islandCnt];

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        int result = 0;
        minEdge[1] = 0;

        for (int i = 1; i < islandCnt; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;
            for (int j = 1; j < islandCnt; j++) {
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            if (minVertex == -1)
                return -1;
            visited[minVertex] = true;
            result += min;

            for (int j = 1; j < islandCnt; j++) {
                if (!visited[j] && arr[minVertex][j] != 0 && minEdge[j] > arr[minVertex][j]) {
                    minEdge[j] = arr[minVertex][j];
                }
            }
        }
        return result;
    }

    // bfs
    private static void calcDistance() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int[] island : list) {

            q.offer(new int[] { island[0], island[1] });
            int curIdx = map[island[0]][island[1]];
            visited[island[0]][island[1]] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                visited[curX][curY] = true;

                for (int d = 0; d < 4; d++) {
                    int nx = curX + dx[d];
                    int ny = curY + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                        continue;
                    if (map[nx][ny] == 0) {
                        int index = connectIsland(nx, ny, d);
                        if (index > 0) {
                            arr[curIdx][index] = Math.min(arr[curIdx][index], count); // 최소 다리 길이 저장
                        }
                    } else if (map[nx][ny] == curIdx && !visited[nx][ny]) {
                        q.offer(new int[] { nx, ny });
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static int connectIsland(int x, int y, int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        count = 0;

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            count++;
            if (map[nx][ny] != 0) {
                if (count == 1)
                    return 0; // 다른 섬까지 다리 길이가 1이면 연결 불가능
                return map[nx][ny]; // 연결 가능한 섬의 번호 리턴
            }

            nx = nx + dx[d];
            ny = ny + dy[d];
        }

        return 0; // 연결 가능한 섬 없음

    }

    // bfs
    private static void numberingMap() {

        Queue<int[]> q = new LinkedList<int[]>();

        islandCnt = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = islandCnt;
                    list.add(new int[] { i, j });
                    q.offer(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int curX = cur[0];
                        int curY = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int nx = curX + dx[d];
                            int ny = curY + dy[d];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                                continue;

                            if (map[nx][ny] == -1) {
                                q.offer(new int[] { nx, ny });
                                map[nx][ny] = islandCnt;
                            }
                        }
                    }
                    islandCnt++;
                }

            }
        }

    }
}
