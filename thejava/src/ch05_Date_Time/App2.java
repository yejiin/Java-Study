package ch05_Date_Time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App2 {

    public static void main(String[] args) {
        // machine time
        Instant instant = Instant.now();
        System.out.println(instant);  // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC")));  // 기준시 UTC, GMT

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);



        // human time
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthDay = LocalDateTime.of(2000, Month.JULY, 1, 0, 0, 0);

        // 특정 zone의 시간
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        // Instant <--> ZonedDateTime
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);;
        zonedDateTime1.toInstant();



        // period
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2020, Month.JULY, 15);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));



        // duration
        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now1, plus);
        System.out.println(between.getSeconds());



        // formatting
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now2.format(MMddyyyy));

        // parsing
        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println(parse);



        Date date = new Date();
        Instant instant1 = date.toInstant();
        Date newDate = Date.from(instant1);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(dateTime);

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

        LocalDateTime now4 = LocalDateTime.now();
        now4.plus(10, ChronoUnit.DAYS);
    }
}
