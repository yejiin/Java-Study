package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - 하나의 차선으로 된 다리
 * - n(<=1000)개의 트럭이 다리 길이 1만큼 순서대로 지나감
 * - 다리 길이는 w(<=100)이며, w대의 트럭만 동시에 다리 위에 있을 수 있음
 * - 다리 위 트럭의 무게의 합 <= L(<=1000)
 *
 * output : 모든 트럭들이 다리를 건너는 최단시간
 *
 * 문제풀이
 * time 현재시간, truckWeights 트럭 무게 리스트, index 트럭 번호
 * Queue 다리에 있는 트럭(트럭 번호, 들어간 시간)
 * 1. 트럭의 무게 List<Integer> 에 저장
 * 2. while 돌면서 시간+1
 *  1. 내릴 트럭이 있는지 확인 후 큐에서 제거
 *  2. 다리 위에 있는 트럭 수가 w보다 크면 continue
 *  3. 다리 위에 올라갈 트럭이 있는지 확인 후 큐에 추가
 *  4. 마지막 트럭이 다리 위에 올라간 경우 다리를 건널 시간을 더해주고 종료
 */
public class Main_BOJ_13335_트럭 {

    private static int n;
    private static int w;
    private static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        List<Integer> truckWeights = new ArrayList<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            truckWeights.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int index = 0;
        int totalWeights = 0;
        Queue<Truck> bridge = new LinkedList<>();

        while (true) {
            ++time;

            // 1. 내릴 트럭이 있는지 확인
            if (bridge.size() > 0 && time - bridge.peek().entranceTime == w) { // 맨 앞 트럭이 내리는 경우
                Truck frontTruck = bridge.poll();
                totalWeights -= truckWeights.get(frontTruck.index);
            }

            // 2. 다리 위에 있는 트럭 수가 w보다 크면 continue
            if (bridge.size() >= w) {
                continue;
            }

            // 3. 다리 위에 올라갈 트럭이 있는지 확인 (다리 위 하중 체크)
            if (totalWeights + truckWeights.get(index) <= L) {
                totalWeights += truckWeights.get(index);
                bridge.add(new Truck(index++, time));
            }

            // 4. 마지막 트럭이 다리 위에 올라간 경우 다리를 건널 시간을 더해주고 종료
            if (index == n) {
                time += w;
                break;
            }
        }
        System.out.println(time);
    }

    private static class Truck {
        int index;
        int entranceTime;

        public Truck(int index, int entranceTime) {
            this.index = index;
            this.entranceTime = entranceTime;
        }
    }
}
