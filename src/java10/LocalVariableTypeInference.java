package java10;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LocalVariableTypeInference {
    public static void main(String[] args) {

        // Style 1:
        var names = List.of("A1", "A2", "A3", "A4", "A5", "A6");

        // Style 2:
        try (var lines = Files.lines(Paths.get("log/catalina.out"))) {
            // Style 3:
            var count = lines.count();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        // Style 4 (Illegal):
        // var n;
        // var emptyList = null;
        // var predicate = (String str) -> str.length() > 10;


    }
}
