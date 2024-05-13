package java8;

import java.util.*;
import java.util.stream.Collectors;

public class CollectingDataWithStreams {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(50, "red"),
                new Apple(150, "Black"),
                new Apple(250, "Green"),
                new Apple(50, "Black"),
                new Apple(50, "Black")
        );

        // Collectors as argument:

        long howManyApples = inventory.stream()
                .collect(Collectors.counting());

        Optional<Apple> mostWeightApple = inventory.stream()
                .collect(Collectors.maxBy(Comparator.comparing(apple -> apple.weight)));

        int totalWeight = inventory.stream()
                .collect(Collectors.summingInt(apple -> apple.weight));

        double averageWeight = inventory.stream()
                .collect(Collectors.averagingDouble(apple -> apple.weight));


        // All-in-one
        IntSummaryStatistics appleIntSummaryStatistics = inventory.stream()
                .collect(Collectors.summarizingInt(apple -> apple.weight));

        LongSummaryStatistics appleLongSummaryStatistics = inventory.stream()
                .collect(Collectors.summarizingLong(apple -> apple.weight));

        DoubleSummaryStatistics appleDoubleSummaryStatistics = inventory.stream()
                .collect(Collectors.summarizingDouble(apple -> apple.weight));

        // Joining
        String colors = inventory.stream().map(apple -> apple.color).collect(Collectors.joining(","));


        // Grouping:

        Map<Boolean, List<Apple>> applesByWeight = inventory.stream().collect(Collectors.groupingBy(apple -> apple.weight > 100));

        enum COLOR {RED, BLACK, GREEN}
        Map<COLOR, List<Apple>> applesByColor = inventory.stream().collect(Collectors.groupingBy(apple -> {
            if (apple.color.equalsIgnoreCase(COLOR.RED.toString())) return COLOR.RED;
            else if (apple.color.equalsIgnoreCase(COLOR.BLACK.toString())) return COLOR.BLACK;
            else return COLOR.GREEN;
        }));

        Map<Integer, Map<COLOR, List<Apple>>> multilevel = inventory.stream()
                .collect(Collectors.groupingBy(apple -> apple.weight, Collectors.groupingBy(
                        apple -> {
                            if (apple.color.equalsIgnoreCase(COLOR.RED.toString())) return COLOR.RED;
                            else if (apple.color.equalsIgnoreCase(COLOR.BLACK.toString())) return COLOR.BLACK;
                            else return COLOR.GREEN;
                        }
                )));

        Map<COLOR, Long> colorCount = inventory.stream()
                .collect(Collectors.groupingBy(apple -> {
                    if (apple.color.equalsIgnoreCase(COLOR.RED.toString())) return COLOR.RED;
                    else if (apple.color.equalsIgnoreCase(COLOR.BLACK.toString())) return COLOR.BLACK;
                    else return COLOR.GREEN;
                }, Collectors.counting()));

        Map<COLOR, Optional<Apple>> mostWeightByColor = inventory.stream()
                .collect(Collectors.groupingBy(apple -> {
                    if (apple.color.equalsIgnoreCase(COLOR.RED.toString())) return COLOR.RED;
                    else if (apple.color.equalsIgnoreCase(COLOR.BLACK.toString())) return COLOR.BLACK;
                    else return COLOR.GREEN;
                }, Collectors.maxBy(Comparator.comparing(apple -> apple.weight))));

        // Partitioning:
        Map<Boolean, List<Apple>> appleWeightPartitioning = inventory.stream()
                .collect(Collectors.partitioningBy(apple -> apple.weight > 100));

        Map<Boolean, Map<Boolean, List<Apple>>> appleWeightAndColorPartitioning = inventory.stream()
                        .collect(Collectors.partitioningBy(apple -> apple.weight > 100,
                                Collectors.partitioningBy(x -> x.color.equalsIgnoreCase(COLOR.BLACK.toString()))));

        System.out.println();
    }
}
