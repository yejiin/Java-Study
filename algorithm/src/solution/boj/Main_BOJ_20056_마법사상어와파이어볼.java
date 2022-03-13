package solution.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 출력 : 남아있는 파이어볼 질량의 합
public class Main_BOJ_20056_마법사상어와파이어볼 {

    static int N, M, K;  // N: map 크기, M: 파이어볼 개수, K: 명령 개수

    static Map<String, List<Fireball>> map;
    static Map<String, List<Fireball>> movedMap;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map.put(r + " " + c, new LinkedList<>());
            map.get(r + " " + c).add(new Fireball(r, c, m, s, d));
        }

        // K번 이동
        for (int i = 0; i < K; i++) {
            movedMap = new HashMap<>();

            // 모든 파이어볼 이동
            for (String key : map.keySet()) {
                List<Fireball> fireballs = map.get(key);
                for (int j = 0; j < fireballs.size(); j++) {
                    move(fireballs.get(j));
                }
            }

            map = movedMap;

            // 같은 칸에 두개 이상의 파이어볼이 있는 경우
            ArrayList<String> keys = new ArrayList<>(map.keySet());
            for (String key : keys) {
                if (map.get(key).size() >= 2) {
                    // 파이어볼을 모두 합친후 4개의 파이어볼로 나눔
                    divide(key, map.get(key));
                }
            }
        }
        System.out.println(getSum());
    }

    // 파이어볼 이동
    private static void move(Fireball fireBall) {
        int nr = (fireBall.r + fireBall.s * (dr[fireBall.d] + (dr[fireBall.d] < 0 ? N : 0))) % N;
        int nc = (fireBall.c + fireBall.s * (dc[fireBall.d] + (dc[fireBall.d] < 0 ? N : 0))) % N;


        Fireball newFireball = new Fireball(nr, nc, fireBall.m, fireBall.s, fireBall.d);
        if (movedMap.containsKey(nr + " " + nc))
            movedMap.get(nr + " " + nc).add(newFireball);
        else {
            List<Fireball> fireballs = new LinkedList<>();
            fireballs.add(newFireball);
            movedMap.put(nr + " " + nc, fireballs);
        }
    }

    private static void divide(String key, List<Fireball> fireballs) {
        int dFlag= 0; // 짝수 개수

        int r = fireballs.get(0).r;
        int c = fireballs.get(0).c;
        int size = fireballs.size();  // fireball 크기

        int sumM = 0;  // 총 질량
        int sumS = 0;  // 총 속력

        for (int i = 0; i < fireballs.size(); i++) {
            sumM += fireballs.get(i).m;
            sumS += fireballs.get(i).s;
            dFlag += (fireballs.get(i).d % 2) == 0 ? 1 : 0;
        }

        int m = sumM / 5;
        int s = sumS / size;

        if (m == 0) {
            map.remove(key);
            return;
        }

        fireballs.clear();
        int d = (dFlag == size || dFlag == 0) ? 0 : 1;
        for (int i = 0; i < 4; i++) {
            fireballs.add(new Fireball(r, c, m, s, i * 2 + d));
        }
    }

    private static int getSum() {
        int sum = 0;

        for (String key : map.keySet())
            sum += map.get(key).stream().mapToInt(fireball -> fireball.m).sum();

        return sum;
    }

    static class Fireball {
        int r, c, m, s, d;  // r, c: 위치, m: 질량, d: 방향, s: 속력

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
