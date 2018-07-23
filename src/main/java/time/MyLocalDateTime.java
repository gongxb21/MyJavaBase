package time;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author gongxb
 * @date 2018/5/21
 * @dsc
 * @return
 */
public class MyLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2018, Month.MAY, 21, 23, 50, 50);
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = dateTime.getMonth();
        System.out.println(month);

        long minuteOfDay = dateTime.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();

        Date now = Date.from(instant);

        System.out.println(now);

        /*DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy:MM:dd");

        LocalDateTime parsed=LocalDateTime.parse("2018:01:01", formatter);
        String string=parsed.format(formatter);*/
        //System.out.println(string);
    }
}







