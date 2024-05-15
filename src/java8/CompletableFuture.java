package java8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFuture {
    public static void main(String[] args) {

        // Do NOT return anything:
        java.util.concurrent.CompletableFuture<Void> future1 = java.util.concurrent.CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                throw new IllegalStateException(exception);
            }
            System.out.println("Seperated thread: runAsync()");
        });

        // Return anything:
        java.util.concurrent.CompletableFuture<String> future2 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                throw new IllegalStateException(exception);
            }
            System.out.println("Seperated thread: supplyAsync()");
            return "Hello World";
        });


        // Where is the thread?
        // global ForkJoinPool.commonPool()

        var future3 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                throw new IllegalStateException(exception);
            }
            System.out.println("Seperated thread: supplyAsync() with an executor");
            return "Hello World";
        }, Executors.newFixedThreadPool(3));


        // Passing a callback:
        // thenApply(), thenAccept(), thenRun()

        var future4 = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException exception) {
                throw new IllegalStateException(exception);
            }
            return "Hello ";
        });
        var future5 = future4.thenApply(s -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException exception) {
                throw new IllegalStateException(exception);
            }
            return s + "World!";
        });

        try {
            System.out.println("1: " + future5.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        // future5.thenApply(s -> s + " from Java8").thenApply(s -> s + " and from CompletableFuture").thenApply(s -> s + ", and welcome to Tektra!");
        // System.out.println(future5.get());

        var future6 = future5
                .thenApply(s -> s + " from Java8")
                .thenApply(s -> s + " and from CompletableFuture")
                .thenApply(s -> s + ", and welcome to Tektra!");

        try {
            System.out.println("2: " + future6.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        // thenApply() -> return anything
        // thenAccept() and thenRun() -> return nothing

        var future7 = future6.thenAccept(s -> System.out.println("thenAccept: " + s));
        var future8 = future6.thenRun(() -> System.out.println("thenRun: :)"));

        try {
            System.out.println("3: " + future7.get());
            System.out.println("4: " + future8.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        // Threads
        java.util.concurrent.CompletableFuture.runAsync(() -> {
            // thread X
        }).thenApplyAsync(result -> {
            return "thread Y";
        });


        // Combination:
        // CompletableFuture<User> getUserDetails(String userId) -> CompletableFuture<Double> getCreditRating(User user)

        // Style 1:
        // CompletableFuture<CompletableFuture<Double>> res = getUserDetails(userId).thenApply(user -> getCreditRating(user))

        // Style 2:
        // CompletableFuture<Double> res = getUserDetails(userId).thenCompose(user -> getCreditRating(user))


        // TimeOut/Exception/...
        //        CompletableFuture<MyObject> futureTask =
        //                CompletableFuture.supplyAsync(() -> candidate, pool)
        //                        .thenApply(Task1::doWork).thenApply(Task2::doWork).thenApply(Task3::doWork)
        //                        .thenApply(Task4::doWork).thenApply(Task5::doWork).orTimeout(30, TimeUnit.SECONDS)
        //                        .thenApply(Task6::doWork).orTimeout(30, TimeUnit.SECONDS)
        //                        .exceptionally(ExceptionHandlerService::handle);
    }

}
