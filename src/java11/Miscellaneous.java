package java11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Miscellaneous {
    public static void main(String[] args) {

        // 1:
        List<String> list = Arrays.asList("a", "b", "c");
        String[] arr = list.toArray(String[]::new);

        // 2:
        List<String> withoutBlanks = list.stream()
                .filter(Predicate.not(String::isBlank)) // JDK8 : negate()
                .toList();

        // 3:
        String res = withoutBlanks.stream()
                .map((var x) -> x.toUpperCase())
                .collect(Collectors.joining(", "));


    }
}
