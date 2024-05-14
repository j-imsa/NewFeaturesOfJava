package java8;

public class DefaultMethods implements Washable<Integer> {

    public static void main(String[] args) {
        // Style 1:
        Washable<Integer> washable = new DefaultMethods();
        washable.doIt();

        // Style 2:
        DefaultMethods defaultMethods = new DefaultMethods();
        defaultMethods.doIt();

        // Style 3:
        DefaultMethods.doIt();

        // Style 4:
        Washable.doIt();
    }

    @Override
    public Integer wash() {
        return -1;
    }

    @Override
    public boolean isThereAnyMore() {
        return !false;
    }
}

interface Washable<T> {
    T wash();

    boolean isThereAnyMore();

    default void remove() {
        throw new UnsupportedOperationException();
    }

    static void doIt() {
        System.out.println("Doing...");
    }
}