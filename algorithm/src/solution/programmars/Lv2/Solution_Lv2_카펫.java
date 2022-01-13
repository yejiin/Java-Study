package solution.programmars.Lv2;

import java.util.HashSet;
import java.util.Objects;

public class Solution_Lv2_카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        HashSet<Area> set = new HashSet<>();

        int area = brown + yellow;
        for (int i = 1; i <= area; i++) {
            if (area % i == 0) {
                if (i > (area / i))
                    break;
                set.add(new Area(i, area / i));
            }
        }

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                if (set.contains(new Area(i + 2, (yellow / i) + 2))) {
                    answer[0] = (yellow / i) + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        return answer;
    }

    static class Area {
        int h, w;

        public Area(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Area shape = (Area) o;
            return h == shape.h && w == shape.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h, w);
        }
    }
}
