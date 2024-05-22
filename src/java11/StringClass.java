package java11;

import java.util.List;
import java.util.stream.Collectors;

public class StringClass {
    public static void main(String[] args) {
        System.out.println("Hello World".isBlank());
        System.out.println(" ".isBlank());
        System.out.println("".isBlank());

        System.out.println("Hello World".isEmpty());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());

        String s = "Hello World";
        List<String> lines = s.lines() // Stream<String>
                .filter(s1 -> !s1.isBlank())
                .map(String::strip) // vs trim
                .collect(Collectors.toUnmodifiableList());

        String sTrim = " Hello World ".trim();
        String sStrip = " Hello World ".strip();
        String sStripLeading = " Hello World ".stripLeading();
        String sStripTrailing = " Hello World ".stripTrailing();
        String sStripIndent = " Hello World ".stripIndent();
        System.out.printf("1: '%s', '%s', '%s', '%s', '%s'\n", sTrim, sStrip, sStripLeading, sStripTrailing, sStripIndent);
        System.out.printf("2: '%s', '%s', '%s', '%s', '%s'\n", "".trim(), "".strip(), "".stripLeading(), "".stripTrailing(), "".stripIndent());
        System.out.printf("3: '%s', '%s', '%s', '%s', '%s'\n", " ".trim(), " ".strip(), " ".stripLeading(), " ".stripTrailing(), " ".stripIndent());

        System.out.println("Iman ".repeat(5));
    }
}
