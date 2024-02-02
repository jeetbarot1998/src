package OCA_Dumps;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Q5 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.parse("2023-05-12");
        System.out.println(ld);
        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter dtm2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate ld1 = LocalDate.parse("12-05-2023",dtm);
        System.out.println(ld1);
        String formattedDate = ld1.format(dtm);
        String formattedDate2 = ld.format(dtm);
        System.out.println("formattedDate ======= " + formattedDate);
        System.out.println("formattedDate2 ======= " + formattedDate2);

        DateTimeFormatter MMDDyyyy = DateTimeFormatter.ofPattern("MMM dd,yyyy");
        System.out.println(LocalDate.parse("Jan 14,2020", MMDDyyyy));
        LocalDate date3 = LocalDate.parse("11-30-2022", dtm2);
        System.out.println(date3);
        System.out.println(date3.format(MMDDyyyy));

        System.out.println("Date here in india is : " + LocalDate.now());
        ZoneId zni = ZoneId.of("America/Los_Angeles");
        LocalDate ld2 = LocalDate.now(zni);
        System.out.println("Date America/Los_Angeles : " + ld2);

        System.out.println("Time here in india is : " + LocalTime.now());
        System.out.println("Time America/Los_Angeles : " + LocalTime.now(zni));

    }
}











