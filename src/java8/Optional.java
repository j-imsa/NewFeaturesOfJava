package java8;

public class Optional {
    public static void main(String[] args) {

        MyCar myCar = new MyCar();

        java.util.Optional<MyCar> myCar1 = java.util.Optional.empty();
        java.util.Optional<MyCar> myCar2 = java.util.Optional.of(myCar);

        myCar = null;
        java.util.Optional<MyCar> myCar3 = java.util.Optional.of(myCar);
        java.util.Optional<MyCar> myCar4 = java.util.Optional.ofNullable(myCar);

        // Extracting:
        String name = myCar2
                .map(xCar -> xCar.insurance.get().name)
                .orElse(null);


    }
}


class Person {
    java.util.Optional<MyCar> myCar; // might or might not
}

class MyCar {
    java.util.Optional<Insurance> insurance; // might or might not
}

class Insurance {
    String name; // must have name
}