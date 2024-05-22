package java11;

public class NestBasedAccessControl {
    private String privateField = "Private Data";

    public class InnerClass {
        private String privateInnerField = "Private Inner Data";

        public void accessOuter() {
            System.out.println(privateField); // Direct access to NestBasedAccessControl's private field
        }
    }

    private static class NestedStaticClass {
        private String privateStaticField = "Private Static Data";

        public void accessInner() {
            InnerClass inner = new NestBasedAccessControl().new InnerClass();
            // System.out.println(inner.privateField); // Not possible
            System.out.println(inner.privateInnerField); // Allowed
        }
    }

    public static void main(String[] args) {
        NestBasedAccessControl outer = new NestBasedAccessControl();
        InnerClass inner = outer.new InnerClass();
        inner.accessOuter();
    }
}
