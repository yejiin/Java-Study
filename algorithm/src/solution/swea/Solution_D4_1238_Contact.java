package solution.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact {

    static int LEN;
    static int START;
    static Node[] nodeList;

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            super();
            this.vertex = vertex;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            LEN = Integer.parseInt(st.nextToken());
            START = Integer.parseInt(st.nextToken());
            nodeList = new Node[101];

            st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < LEN / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                nodeList[from] = new Node(to, nodeList[from]);
            }
            sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs() {

        List<Integer> sameDepth = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[101];

        queue.offer(START);
        visited[START] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == 0) {
                if (queue.isEmpty())
                    break;
                sameDepth.clear();
                queue.offer(0);
            } else {
                sameDepth.add(current);
            }

            for (Node temp = nodeList[current]; temp != null; temp = temp.link) {
                if (!visited[temp.vertex]) {
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }

        return getMaxNumber(sameDepth);

    }

    private static int getMaxNumber(List<Integer> sameDepth) {
        int max = 0;
        for (Integer i : sameDepth) {
            max = (i > max) ? i : max;
        }
        return max;

    }
}

