package java8;

import java.util.List;

public class FunctionalProgramming {
    public static void main(String[] args) {

        List<String> names = List.of("Simin", "Ali", "Fereydon", "Yalda", "Mona", "Iman");

        // Imperative: finding 'Iman'
        boolean flag = false;
        for (String name : names) {
            if (name.equals("Iman")) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Foo");
        } else {
            System.out.println("Bar");
        }

        // Declarative: finding 'Iman'
        if (names.contains("Iman")) {
            System.out.println("Foo");
        } else {
            System.out.println("Bar");
        }

        // Higher order function:
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
            }
        });
        th1.start();

        Thread th2 = new Thread(() -> System.out.println("Thread 2"));

    }
}
