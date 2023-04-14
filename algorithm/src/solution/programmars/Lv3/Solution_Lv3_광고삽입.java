package solution.programmars.Lv3;

public class Solution_Lv3_광고삽입 {

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = getTimeToInt(play_time);
        int advTime = getTimeToInt(adv_time);
        int[] times = new int[playTime + 1];

        for (String log : logs) {
            String[] logArr = log.split("-");
            int start = getTimeToInt(logArr[0]);
            int end = getTimeToInt(logArr[1]);

            for (int i = start; i < end; i++) {
                times[i]++;
            }
        }

        long max = 0;

        for (int i = 1; i < advTime; i++) {
            max += times[i];
        }

        int start = 0;
        long tempMax = max;
        for (int i = 0, j = advTime; j < playTime; i++, j++) {
            tempMax = tempMax - times[i] + times[j];

            if (tempMax > max) {
                max = tempMax;
                start = i + 1;
            }
        }
        return getTimeToStr(start);
    }

    private String getTimeToStr(int time){
        String hh, mm, ss;
        hh = (time / 3600) > 9 ? (time / 3600) + "" : "0" + time / 3600;
        time %= 3600;
        mm = (time / 60) > 9? (time / 60) + "" : "0" + time / 60;
        time %= 60;
        ss = time > 9 ? time + "" : "0" + time;

        return hh+":"+mm+":"+ss;
    }

    private int getTimeToInt(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 * 60
                + Integer.parseInt(timeArr[1]) * 60
                + Integer.parseInt(timeArr[2]);
    }
}