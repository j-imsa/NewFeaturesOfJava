package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ComposingLambdaExpressions {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(50, "red"),
                new Apple(150, "Black"),
                new Apple(250, "Green"),
                new Apple(50, "Black")
        );

        // Comparator:
        inventory.sort(Comparator.comparing(new Apple()::compareTo).reversed());
        // Chaining:
        inventory.sort(
                Comparator.comparing(new Apple()::compareTo)
                        .reversed()
                        .thenComparing(new Apple()::compareTo)
        );

        // Predicate:
        java.util.function.Predicate<Apple> redApplePredicate = apple -> apple.color.equalsIgnoreCase("red");
        java.util.function.Predicate<Apple> notRedApplePredicate1 = apple -> !apple.color.equalsIgnoreCase("red");
        java.util.function.Predicate<Apple> notRedApplePredicate2 = redApplePredicate.negate();
        java.util.function.Predicate<Apple> notRedApplePredicate3 = Predicate.not(redApplePredicate);

        Predicate<Apple> redAndHeavyApplePredicate = redApplePredicate
                .and(apple -> apple.weight > 120);

        Predicate<Apple> redAndHeavyOrGreenApplePredicate = redApplePredicate
                .and(apple -> apple.weight > 120)
                .or(apple -> apple.color.equalsIgnoreCase("green"));

        // Functions:
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h1 = f.andThen(g); // gof(x)
        int result = h1.apply(2);
        System.out.println(result);
        Function<Integer, Integer> h2 = f.compose(g); // fog(x)
        result = h1.apply(2);
        System.out.println(result);

    }
}
