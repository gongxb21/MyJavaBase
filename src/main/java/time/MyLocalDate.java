package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

/**
 * @author gongxb
 * @date 2018/5/21
 * @desc
 * @return
 */
public class MyLocalDate {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        System.out.println("today="+today);

        LocalDate tomorrow=today.plus(1, ChronoUnit.DAYS);
        System.out.println("tomorrow="+tomorrow);

        LocalDate yestoday=today.minus(1,ChronoUnit.DAYS);
        System.out.println("yesToday="+yestoday);

        LocalDate day=LocalDate.of(2018, Month.MAY,21);
        System.out.println("day="+day);

        DayOfWeek dayOfWeek=day.getDayOfWeek();
        System.out.println("dayofWeek="+dayOfWeek);

        DateTimeFormatter formatter=DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMANY);
        LocalDate date=LocalDate.parse("11.11.2014",formatter);
        System.out.println("date="+date);
    }
}
