package abstracttest.instance;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
//		Calendar cal = new Calendar(); // error
//		1.
//		Calendar cal = new GregorianCalendar();
//		2.
		String ap[] = { "오전", "오후" };
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR); // Calendar.YEAR는 인덱스 값이고 get()으로 현재 시간이 계산된 배열에서 값 가져옴
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DAY_OF_MONTH);
//		int h = cal.get(Calendar.HOUR_OF_DAY);
		int h = cal.get(Calendar.HOUR);
		int apm = cal.get(Calendar.AM_PM);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println("시간: " + y + "년 " + m + "월 " + d + "일 " + ap[apm] + " " + h + "시 " + "분 " + s + "초");

		// 21.07.28 13:57:57
		Format f = new SimpleDateFormat("yy.MM.dd HH:mm:ss"); // 날짜 형식 지정
//		Date date = new Date();
//		String day = f.format(date);
		String day = f.format(new Date()); // new Date() 익명으로 객체 생성
		System.out.println(day);
	}

}
