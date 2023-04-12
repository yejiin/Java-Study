package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main_BOJ_2212_센서 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());

        // 센서 좌표 저장
        List<Integer> sensors = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // 센서 좌표 오름차순 정렬
        Collections.sort(sensors);

        // 센서간 거리 저장
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < sensors.size() - 1; i++) {
            distances.add(sensors.get(i + 1) - sensors.get(i));
        }

        // 센서간 거리 오름차순 정렬
        Collections.sort(distances);

        // 거리가 짧은 순으로 N-K개의 거리를 최솟값으로 수신
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += distances.get(i);
        }
        System.out.println(result);
    }
}