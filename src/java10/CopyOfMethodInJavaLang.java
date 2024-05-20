package java10;

import java.util.List;

public class CopyOfMethodInJavaLang {
    public static void main(String[] args) {
        var names = List.of("A1", "A2", "A3", "A4", "A5", "A6");
        List<String> copyNames = List.copyOf(names);
        copyNames.add("A7"); // Immutable object is modified!
    }
}
