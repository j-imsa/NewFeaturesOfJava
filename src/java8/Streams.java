package java8;

import java.util.*;

public class Streams {
    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("vis", 100),
                new Dish("maaltijd", 150),
                new Dish("kip", 300),
                new Dish("groente", 50)
        );

        // Java 7 style:
        List<Dish> lowCalorieDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalorie() < 200) {
                lowCalorieDishes.add(dish);
            }
        }
        Collections.sort(lowCalorieDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalorie(), o2.getCalorie());
            }
        });
        List<String> lowCalorieDishesNames = new ArrayList<>();
        for (Dish dish : lowCalorieDishes) {
            lowCalorieDishesNames.add(dish.getName());
        }

        // Java 8 style:

        List<String> lowCalorieDishesNamesByJava8 = menu.stream()
                .filter(dish -> dish.getCalorie() < 200) // intermediate operation
                .sorted(Comparator.comparing(Dish::getCalorie)) // intermediate operation
                .map(Dish::getName) // intermediate operation
                .toList(); // terminal operation

        // Print:

        // Java 7 style:
        Iterator<String> iterator = lowCalorieDishesNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Java 8 style:
        lowCalorieDishesNamesByJava8.stream()
                .forEach(System.out::println);



        // find count using reduce ;)


    }
}

class Dish {
    private String name;
    private int calorie;

    public Dish(String name, int calorie) {
        this.name = name;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }
}