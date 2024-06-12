package java8;


public class FunctionalInterface {
    public static void main(String[] args) {
        MyPredicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
        MyConsumer<String> stringPrinterConsumer = s -> System.out.println(s);
        MyFunction<String, Integer> stringToLengthFunction = s -> s.length();


        // Exercise:
        //        T -> R
        //        (int, int) -> int
        //        T -> void
        //        () -> T
        //        (T, U) -> R
    }
}

@java.lang.FunctionalInterface
interface MyPredicate<T> {
    boolean test(T t);
}

interface MyConsumer<T> {
    void accept(T t);
}

interface MyFunction<T, R> {
    R apply(T t);
}