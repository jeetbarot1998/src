package OCP.Stream_Api_2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class Dates_Api_Changes {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        Calendar c =  Calendar.getInstance();
        System.out.println(c.getTime());
        c.set(2020,10,28);
        System.out.println(c.getTime());
        c.set(2020, Calendar.OCTOBER,19);
        System.out.println(c.getTime());
    }
}

class Date_Api_Changes_Local_Date{
    public static void main(String[] args) {
//         ================= With Clock =================
        Clock c = Clock.systemDefaultZone();
        LocalDate ld = LocalDate.now(c);

        LocalTime lt = LocalTime.now();

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);
        LocalDate ld1 = LocalDate.of(2020,10,18);
        System.out.println(ld1);
        LocalDate ld2 = LocalDate.parse("2020-10-18");
        System.out.println(ld2);
        System.out.println(ld1.getMonth());
        System.out.println(ld1.getMonthValue());
        System.out.println(ld1.getDayOfMonth());
        System.out.println(ld1.getDayOfWeek());
        System.out.println(ld1.getDayOfYear());
//        ================= Zone id =================
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        ZoneId z_id = ZoneId.of("America/Cuiaba");
        LocalDate ld_zone = LocalDate.now(z_id);
        System.out.println("ld_zone : " + ld_zone);

    }
}

class Date_Api_Changes_Local_Time{
    public static void main(String[] args) {
        LocalTime lt = LocalTime.now();
        System.out.println("getHour : " + lt.getHour());
        System.out.println("getMinute : " + lt.getMinute());
        System.out.println("getSecond : " + lt.getSecond());
        System.out.println("getNano : " + lt.getNano());


//        ================= Zone id =================
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        ZoneId z_id = ZoneId.of("America/Cuiaba");
        LocalTime lt_zone = LocalTime.now(z_id);
        System.out.println("lt_zone : " + lt_zone);
    }
}

class Date_Api_Changes_Local_Date_Time{
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("getHour : " + ldt.getHour());
        System.out.println("getMinute : " + ldt.getMinute());
        System.out.println("getSecond : " + ldt.getSecond());
        System.out.println("getNano : " + ldt.getNano());
        System.out.println("getMonth : " + ldt.getMonth());
        System.out.println("getMonthValue : " + ldt.getMonthValue());
        System.out.println("getDayOfMonth : " + ldt.getDayOfMonth());
        System.out.println("getDayOfWeek : " + ldt.getDayOfWeek());
        System.out.println("getDayOfYear : " + ldt.getDayOfYear());

//        ================= Zone id =================
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        ZoneId z_id = ZoneId.of("America/Cuiaba");
        LocalDateTime ldt_zone = LocalDateTime.now(z_id);
        System.out.println("ldt_zone : " + ldt_zone);

        System.out.println("plusDays : " + ldt.plusDays(10));
        System.out.println("plusHours : " + ldt.plusHours(10));
        System.out.println("plusWeeks : " + ldt.plusWeeks(10));

    }
}

class PeriodDemo{
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
    }
}


