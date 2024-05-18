package java9;

public interface PrivateMethodInInterfaces {

    private static String getName() {
        return "getName method!";
    }

    private String start() {
        return "START!";
    }

    default void check() {
        String name = getName();
        PrivateMethodInInterfaces privateMethodInInterfaces = new PrivateMethodInInterfaces() {
            @Override
            public void check() {
                PrivateMethodInInterfaces.super.check();
            }
        };
        name = privateMethodInInterfaces.start();
    }
}
