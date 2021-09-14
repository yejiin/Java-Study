package solution.boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_16236_아기상어 {

    static int N;
    static int size, sharkX, sharkY, count;
    static int[][] map;
    static int time;

    static ArrayList<Fish> fishes;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist < o.dist) {
                return -1;
            } else if (this.dist == o.dist) {
                if (this.x == o.x) {
                    if (this.y < o.y)
                        return -1;
                    else
                        return 1;
                } else {
                    if (this.x > o. x)
                        return 1;
                    else
                        return -1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        size = 2;  // 아기 상어의 초기 크기

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                int d = Integer.parseInt(st.nextToken());
                map[i][j] = d;
                if (d == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            fishes = new ArrayList<>();  // 먹을 수 있는 물고기를 저장해 놓는 리스트

            Queue<Fish> q = new LinkedList<>();  // bfs
            boolean visited[][] = new boolean[N][N];

            q.offer(new Fish(sharkX, sharkY, 0));  // 상어의 위치 queue에 삽입. 거리는 0
            visited[sharkX][sharkY] = true;

            while(!q.isEmpty()) {
                Fish shark = q.poll();

                // 상, 좌, 하, 우 탐색
                for (int d = 0; d < 4; d++) {
                    int nx = shark.x + dx[d];
                    int ny = shark.y + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    if (visited[nx][ny])
                        continue;


                    if (map[nx][ny] != 0 && map[nx][ny] < size) { // 먹이를 찾은 경우
                        q.offer(new Fish(nx, ny, shark.dist + 1));  // 상어 위치 갱신
                        fishes.add(new Fish(nx, ny, shark.dist + 1));
                        visited[nx][ny] = true;
                    } else if (map[nx][ny] == size || map[nx][ny] == 0) {  // 자신과 사이즈가 같은 물고기를 만나거나 지나갈 수 있는 경우
                        q.offer(new Fish(nx, ny, shark.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }

            // 먹을 물고기가 없는 경우
            if (fishes.size() == 0) {
                System.out.println(time);
                return;
            }

            // 먹을 물고기가 있는 경우. 우선순위에 따라 정렬
            Collections.sort(fishes);
            Fish eatFish = fishes.get(0);

            time += eatFish.dist;  // 먹은 물고기의 거리만큼 시간 증가
            count++;
            map[eatFish.x][eatFish.y] = 0;  // map에 먹은 물고기 처리

            // 자신의 크기만큼 물고기를 먹은 경우
            if (count == size) {
                size++;
                count = 0;
            }

            // 아기 상어 위치 갱신
            sharkX = eatFish.x;
            sharkY = eatFish.y;
        }
    }
}
