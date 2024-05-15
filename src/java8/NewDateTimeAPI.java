package java8;

import java.time.*;

public class NewDateTimeAPI {
    public static void main(String[] args) {

        // System.out.println(new Date(12, 12, 12));

        System.out.println(LocalDate.of(12, 12, 12));
        LocalDate today = LocalDate.now();
        System.out.println(today);

        System.out.println(LocalTime.of(12, 12, 12));
        LocalTime todayTime = LocalTime.now();
        System.out.println(todayTime);

        LocalDate d1 = LocalDate.parse("2020-12-11");
        LocalTime t1 = LocalTime.parse("12:12:11");
        LocalDateTime ldt = LocalDateTime.of(d1, t1);
        System.out.println(ldt);

        // unix epoch
        Instant timestamp = Instant.now();
        System.out.println(timestamp);


        Duration duration = Duration.between(LocalTime.of(20, 12, 11), LocalTime.of(20, 12, 15));
        System.out.println(duration);

        Period period = Period.between(LocalDate.of(2020, 12, 11), LocalDate.of(2020, 12, 15));
        System.out.println(period);


    }
}
