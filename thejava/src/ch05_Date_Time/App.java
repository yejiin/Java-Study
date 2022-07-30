package ch05_Date_Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        long time = date.getTime();  // 모호한 클래스명 (Date 클래스에서 time 사용)

        // mutable (멀티 스레드 환경에서 안전하게 사용하기 어려움)
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);   //
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);    // 위와 다르게 출력

        // 버그 발생 여지가 많다. (month 0부터 시작)
        Calendar birthDay = new GregorianCalendar(2000, 0, 1);
        Calendar birthDay1 = new GregorianCalendar(2000, Calendar.JANUARY, 1);

    }
}
