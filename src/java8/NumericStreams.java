package java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void main(String[] args) {

        // Values
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        LongStream longStream = LongStream.of(1, 2, 3, 4, 5);
        DoubleStream doubleStream = DoubleStream.of(1.2, 2.3, 3.4, 4.5, 5.6);

        OptionalInt min = intStream.min();
        OptionalLong max = longStream.max();
        OptionalDouble average = doubleStream.average();

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(num -> num % 2 == 0);
        System.out.println(evenNumbers.count());

        Stream<String> emptyStream = Stream.empty();

        // Arrays:
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(arr).sum();

        // Files:
        // What is the x?
        long x = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            x = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

        // Methods:
        // iterate:
        Stream.iterate(0, n -> n + 2).limit(10).forEach(n -> System.out.print(n + ", "));
        // generate:
        Stream.generate(Math::random).limit(10).forEach(n -> System.out.print(n + ", "));

    }
}
