package java8;



public class FunctionalInterface {
    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
        Consumer<String> stringPrinterConsumer = s -> System.out.println(s);
        Function<String, Integer> stringTolengthFunction = s -> s.length();


        // Exercise:
        //        T -> R
        //        (int, int) -> int
        //        T -> void
        //        () -> T
        //        (T, U) -> R
    }
}

@java.lang.FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

interface Consumer<T> {
    void accept(T t);
}

interface Function<T, R> {
    R apply(T t);
}