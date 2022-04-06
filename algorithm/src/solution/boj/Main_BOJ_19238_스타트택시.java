package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BOJ_19238_스타트택시 {

    static int N, M, fuel;
    static int[][] map;
    static int[] taxi;
    static Map<String, int[]> customers;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        taxi = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};

        customers = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;

            map[sx][sy] = i + 2;
            customers.put(sx + ":" + sy, new int[]{ex, ey});
        }

        for (int i = 0; i < M; i++) {
            // 택시에 태울 승객 찾기
            Customer customer = findCustomer(taxi[0], taxi[1]);

            if (customer == null) {  // 손님을 태우지 못하는 경우
                fuel = -1;
                break;
            }

            // 택시 위치 변경
            taxi[0] = customer.x;
            taxi[1] = customer.y;
            map[customer.x][customer.y] = 0;

            fuel -= customer.distance;
            if (fuel < 0) {  // 연료 떨어지면 종료
                fuel = -1;
                break;
            }

            // 택시 이동
            int distance = moveTaxi(customer.x, customer.y);
            if (distance == -1) {
                fuel = -1;
                break;
            }

            taxi = customers.get(customer.x + ":" + customer.y);
            fuel -= distance;
            if (fuel < 0) {  // 연료 떨어지면 종료
                fuel = -1;
                break;
            }

            fuel += distance * 2;
        }
        System.out.println(fuel);
    }

    private static Customer findCustomer(int x, int y) {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Customer> cQueue = new PriorityQueue();

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]] > 1)
                cQueue.offer(new Customer(cur[0], cur[1], cur[2]));

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (visited[nx][ny] || map[nx][ny] == 1)
                    continue;

                q.offer(new int[] {nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        return cQueue.poll();
    }

    private static int moveTaxi(int x, int y) {
        boolean[][] visited = new boolean[N][N];
        int[] dest = customers.get(x + ":" + y);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                if (visited[nx][ny] || map[nx][ny] == 1)
                    continue;

                if (nx == dest[0] && ny == dest[1])
                    return cur[2] + 1;

                q.offer(new int[] {nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }


    static class Customer implements Comparable<Customer>{
        int x, y, distance;

        public Customer(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Customer o) {

            if (this.distance == o.distance) {
                if (this.x == o.x)
                    return this.y - o.y;
                return this.x - o.x;
            }

            return this.distance - o.distance;
        }
    }
}
