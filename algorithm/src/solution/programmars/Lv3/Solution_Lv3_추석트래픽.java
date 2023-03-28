package solution.programmars.Lv3;

public class Solution_Lv3_추석트래픽 {

    public int solution(String[] lines) {
        int answer = 1;
        for (int i = 0; i < lines.length; i++) {
            long endTime = getMilSecond(lines[i].split(" ")[1]);
            int cnt = 0;
            for (int j = i; j < lines.length; j++) {
                String[] line = lines[j].split(" ");
                long etime = getMilSecond(line[1]);
                long stime = etime - (long) (Double.parseDouble(line[2].replace("s" , "")) * 1000) + 1;

                if (endTime + 1000 > stime) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }


    private long getMilSecond(String time) {
        String[] pre = time.split(":");
        long endTime = 0;
        endTime += (Long.parseLong(pre[0]) * 60 * 60);
        endTime += (Long.parseLong(pre[1]) * 60);
        endTime *= 1000;
        endTime += (Double.parseDouble(pre[2]) * 1000);
        return endTime;
    }
}
