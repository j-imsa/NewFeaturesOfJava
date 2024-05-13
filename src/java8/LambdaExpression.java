package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {
    public static void main(String[] args) {

        // Before:
        Comparator<Apple> cmpByWeight1 = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.compareTo(o2);
            }
        };

        // After:
        Comparator<Apple> cmpByWeight2 = (Apple ap1, Apple ap2) -> ap1.compareTo(ap2);

        // Valid?
        //        () -> {}
        //        () -> "Iman"
        //        () -> {return "Iman";}
        //        (Integer integer) -> return "Iman" + integer;
        //        (String str) -> {"Iman";}


        // Behavior Parameterization:
        List<Apple> inventory = Arrays.asList(
                new Apple(50, "red"),
                new Apple(150, "Black"),
                new Apple(250, "Green"),
                new Apple(50, "Black")
        );
        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> blackApples = filterApples(inventory, new AppleBlackColorPredicate());

        System.out.println(heavyApples);
        System.out.println(blackApples);

        heavyApples = filterApples(inventory, (Apple apple) -> apple.weight > 150);
        blackApples = filterApples(inventory, (Apple apple) -> apple.color.equalsIgnoreCase("Black"));

    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> returnValue = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.check(apple)) {
                returnValue.add(apple);
            }
        }
        return returnValue;
    }
}

class Apple implements Comparable<Apple> {
    public int weight;
    public String color;

    public Apple() {
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public int compareTo(Apple o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

interface ApplePredicate {
    public boolean check(Apple apple);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean check(Apple apple) {
        return apple.weight > 150;
    }
}

class AppleBlackColorPredicate implements ApplePredicate {
    @Override
    public boolean check(Apple apple) {
        return "Black".equalsIgnoreCase(apple.color);
    }
}

