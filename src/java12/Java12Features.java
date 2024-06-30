package java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12Features {
    public static void main(String[] args) {

        // String

        String text = "Hello World!\nFrom J12";

        System.out.println(text.indent(4));
        System.out.println(text.indent(-10));

        System.out.println(text.transform(s -> new StringBuilder(s).reverse().toString()).trim());


        // Files

        try {
            Path path1 = Files.createTempFile("file1", ".txt");
            Files.writeString(path1, "Hello World!");

            Path path2 = Files.createTempFile("file2", ".txt");
            Files.writeString(path2, "Hello World!");

            long mismatch = Files.mismatch(path1, path2);
            System.out.println(mismatch); // -1

            Path path3 = Files.createTempFile("file3", ".txt");
            Files.writeString(path3, "Hello World! A");

            Path path4 = Files.createTempFile("file4", ".txt");
            Files.writeString(path4, "Hello World! B");

            mismatch = Files.mismatch(path3, path4);
            System.out.println(mismatch); // 13

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Collectors

        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        Collectors.summingDouble(a -> a),
                        Collectors.counting(),
                        (sum, count) -> sum / count
                ));
        System.out.println(mean); // 3.0


        // Number Formatter

        NumberFormat shortFormat = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT); // 'Locale(java.lang.String, java.lang.String)' is deprecated since version 19
        shortFormat.setMaximumFractionDigits(2);
        System.out.println(shortFormat.format(2657));

        NumberFormat longFormat = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        longFormat.setMaximumFractionDigits(2);
        System.out.println(longFormat.format(2652));


        // PREVIEW CHANGES

        // Switch:

        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = "";

        // old pattern:

        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                typeOfDay = "Working Day";
                break;
            case SATURDAY:
            case SUNDAY:
                typeOfDay = "Day Off";
                break;
        }

        // new style:

        String newTypeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> typeOfDay = "Working Day";
            case SATURDAY, SUNDAY -> {
                System.out.println("...");
                typeOfDay = "Day Off";
                yield typeOfDay;
            }
        };

        // InstanceOf

        Object obj = "Hello World!";

        // Old Pattern:
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.length());
        }

        // New Style:
        if (obj instanceof String s) {
            System.out.println(s.length());
        }

    }
}
