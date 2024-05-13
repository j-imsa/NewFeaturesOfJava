package java8;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        // Before:
        Comparator<Car> comparator1 = (Car c1, Car c2) -> c1.compareTo(c2);
        // After:
        Comparator<Car> comparator2 = Comparator.comparing(Car::compareTo);


        Supplier<Car> carSupplier1 = () -> new Car();
        Car car1 = carSupplier1.get();

        Supplier<Car> carSupplier2 = Car::new;
        Car car2 = carSupplier2.get();

        Function<Integer, Car> carFunction = Car::new;
        Car car3 = carFunction.apply(120);

    }
}

class Car implements Comparable<Car> {
    public int speed;

    public Car() {
    }

    public Car(int speed) {
        this.speed = speed;
    }

    @Override
    public int compareTo(Car o) {
        return this.speed - o.speed;
    }
}