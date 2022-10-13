package solution.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// N X N 격자, M 개의 파이어볼
// return : 파이어 볼이 K 번 이동 후, 남아있는 파이어볼 질량의 합
//
// 문제 : 자료구조 [리스트 배열] - (파이어 볼이 2개 이상 있는 경우 고려) : 이동할 위치에 있는 파이어볼 리스트
// 질량이 0 일 때 파이어볼 소멸
public class Main_BOJ_20056_마법사상어와파이어볼 {

    static int N, M, K;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1 ,1 ,1 ,0 ,-1 ,-1 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<FireBall> fireBalls = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            FireBall fireBall = new FireBall(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            fireBalls.add(fireBall);
        }

        List<FireBall>[][] map = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < K; i++) {
            // 파이어볼 리스트에 있는 파이어볼 격자로 이동
            move(map, fireBalls);
            // 4개의 파이어볼로 나눔, 파이어볼 리스트에 저장
            divide(map, fireBalls);
        }

        System.out.println(getFireBallWeight(fireBalls));
    }

    private static void move(List<FireBall>[][] map, List<FireBall> fireBalls) {
        for (FireBall fireBall : fireBalls) {
            int nr = (fireBall.r + fireBall.s * (dr[fireBall.d] + (dr[fireBall.d] < 0 ? N : 0))) % N;
            int nc = (fireBall.c + fireBall.s * (dc[fireBall.d] + (dc[fireBall.d] < 0 ? N : 0))) % N;

            fireBall.r = nr;
            fireBall.c = nc;
            map[nr][nc].add(fireBall);
        }

        fireBalls.clear();
    }

    private static void divide(List<FireBall>[][] map, List<FireBall> fireBalls) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = map[i][j].size();
                if (size == 1) {
                    fireBalls.add(map[i][j].get(0));
                } else if (size > 1) {  // 4개로 나누기
                    int nm = getNextWeight(map[i][j]);  // 다음 질량
                    int ns = getNextSpeed(map[i][j]);  // 다음 속력
                    boolean nd = isSameDir(map[i][j]);  // 다음 방향

                    if (nm == 0) {  // 질량이 0이면 소멸
                        map[i][j].clear();
                        continue;
                    }

                    addFireBall(fireBalls, i, j, nm, ns, nd);
                }
                map[i][j].clear();
            }
        }
    }

    private static int getNextWeight(List<FireBall> fireBalls) {
        int sum = 0;
        for (FireBall fireBall : fireBalls) {
            sum += fireBall.m;
        }
        return sum / 5;
    }

    private static int getNextSpeed(List<FireBall> fireBalls) {
        int sum = 0;
        for (FireBall fireBall : fireBalls) {
            sum += fireBall.s;
        }
        return sum / fireBalls.size();
    }

    // 홀수이면 0, 짝수이면 1 더하기 -> 모두 홀수라면 합은 0이고, 모두 짝수라면 합은 리스트의 길이만큼
    private static boolean isSameDir(List<FireBall> fireBalls) {
        int sum = 0;
        for (FireBall fireBall : fireBalls) {
            if (fireBall.d % 2 == 0) {
                sum += 1;
            }
        }

        if (sum == 0 || sum == fireBalls.size())
            return true;
        return false;
    }

    private static void addFireBall(List<FireBall> fireBalls, int r, int c, int weight, int speed, boolean startZero) {
        int i = startZero == true ? 0 : 1;

        while (i <= 7) {
            fireBalls.add(new FireBall(r, c, weight, speed, i));
            i += 2;
        }
    }

    private static int getFireBallWeight(List<FireBall> fireBalls) {
        return fireBalls.stream().mapToInt(f -> f.m).sum();
    }

    private static class FireBall {
        int r;  // 위치 (r, c)
        int c;
        int m;  // 질량
        int s;  // 속력
        int d;  // 방향

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}