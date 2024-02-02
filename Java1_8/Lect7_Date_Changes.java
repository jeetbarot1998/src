package Java1_8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class Lect7_Date_Changes {
    public static void main(String[] args) {
        getLocalDateDetails();
        getLocalTimeDetails();
        getLocalDateTimedetails();
        System.out.println(isLeapYear(1992));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1993));
    }

    private static void getLocalDateTimedetails() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        int yyyy = ldt.getYear();
        int mm = ldt.getMonthValue();
        int dd = ldt.getDayOfMonth();
        int sec = ldt.getSecond();
        int min = ldt.getMinute();
        int hour = ldt.getHour();
        System.out.printf("%d-%d-%d-%d-%d-%d", yyyy,mm,dd,hour,min,sec);
    }

    private static void getLocalTimeDetails() {
        LocalTime lt = LocalTime.now();
        int sec = lt.getSecond();
        int min = lt.getMinute();
        int hour = lt.getHour();
        int nano = lt.getNano();
        System.out.printf("%d-%d-%d-%d", hour,min,sec,nano);
        System.out.println();
        System.out.println(lt);
        System.out.println(lt.plus(10,ChronoUnit.HOURS));
        System.out.println(lt.plus(10,ChronoUnit.HALF_DAYS));
        System.out.println(lt);
        LocalTime lt3 = LocalTime.of(11,45);
        System.out.println(lt3);
        lt3 = LocalTime.of(11,45, 9, 25);
        System.out.println(lt3);
    }

    private static void getLocalDateDetails() {
        Clock c1 = Clock.systemDefaultZone();
        LocalDate ld1 = LocalDate.now(c1);
        System.out.println(ld1);
        Set<String> zn = ZoneId.getAvailableZoneIds();
        System.out.println(zn);
        ZoneId zni = ZoneId.of("America/Los_Angeles");
        LocalDate ld2 = LocalDate.now(zni);
        System.out.println("America/Los_Angeles : " + ld2);
        LocalDate ld = LocalDate.now();
        int yyyy = ld.getYear();
        int mm = ld.getMonthValue();
        int dd = ld.getDayOfMonth();
        System.out.println(dd+":"+mm+":"+yyyy);
        System.out.println(ld);
        System.out.println(ld.getYear());
        System.out.println(ld.getMonth());
        System.out.println(ld.getMonthValue());
        System.out.println(ld.getDayOfMonth());
        System.out.printf("%d-%d-%d", dd,mm,yyyy);
        System.out.println(ld.plusDays(15));
        System.out.println(ld.plus(20, ChronoUnit.DAYS));
        System.out.println(ld.plusMonths(1));

        LocalDate ld4 = LocalDate.of(1947, Month.AUGUST, 15);
        System.out.println(ld4);
    }

    private static boolean isLeapYear(int year){
        Year yy= Year.of(year);
        return yy.isLeap();
    }
}

class PeriodDemo{
    static boolean b=  false;
    public static void main(String[] args) {

        LocalDate ld4 = LocalDate.of(1947, Month.AUGUST, 15);
        LocalDate ld5 = LocalDate.of(1940, Month.SEPTEMBER, 9);
        LocalDate ld6 = ld4.plus(80, ChronoUnit.YEARS);
        Period diff = Period.between(ld4,ld6);
        System.out.println(diff);
        System.out.println(diff.getDays() + diff.getMonths()*30 + diff.getYears()*365);
        System.out.println(Period.between(ld5,ld4));

        LocalDate dt = LocalDate.parse("2022-05-10");
//        LocalDate dt1 = LocalDate.parse("05-10-2022"); // runtime error
        DateTimeFormatter dtfm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate myDate = LocalDate.parse("23-03-2022", dtfm);
        System.out.println(myDate);

        LocalTime lte = LocalTime.parse("11:43:55");
//        LocalTime lte1 = LocalTime.parse("11:43:65"); // RTE as 65 seconds do not exists
        Predicate<Integer> p = (s) -> b = false;
    }
}



















