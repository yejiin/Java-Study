package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 출력 : K년이 지난 후 살아남은 나무의 수
public class Main_BOJ_16235_나무재테크 {

    static int N, M, K;  // N: 땅 크기, M: 나무의 개수, K: 지난 년수
    static int[][] map;
    static int[][] nourishment;  // 추가될 양분 이차원 배열
    static LinkedList<Tree> treeList;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        nourishment = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = 5;
                nourishment[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        treeList = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            treeList.offer(new Tree(x, y, age));
        }

        // K년 지난 후
        for (int i = 0; i < K; i++) {
            aging();
            nourish();
        }
        System.out.println(treeList.size());
    }

    private static void aging() {
        Collections.sort(treeList);

        int size = treeList.size();
        Queue<Tree> deadTreeList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            Tree tree = treeList.poll();

            if (map[tree.x][tree.y] >= tree.age) {  // 땅에 양분이 충분할 때
                map[tree.x][tree.y] -= tree.age;
                tree.age++;
                treeList.offer(tree);

                breed(tree);

            } else {  // 양분이 충분하지 못하면 나무 죽음
                deadTreeList.offer(tree);
            }
        }

        while(!deadTreeList.isEmpty()) {
            Tree tree = deadTreeList.poll();
            map[tree.x][tree.y] += (tree.age / 2);
        }
    }

    private static void breed(Tree tree) {
        if (tree.age % 5 == 0) {  // 번식
            for (int d = 0; d < 8; d++) {
                int nx = tree.x + dx[d];
                int ny = tree.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;

                treeList.offer(new Tree(nx, ny, 1));
            }
        }
    }

    private static void nourish() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += nourishment[i][j];
            }
        }
    }

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}
