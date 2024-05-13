package java8;

import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        // ForkJoinPool.commonPool().setParallelism(10);
        // Thread.ofPlatform()


        long count = 1_000;

        long start = System.nanoTime();
        parallelSum(count);
        long end = System.nanoTime();
        System.out.println("parallelSum : " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        sequentialSum(count);
        end = System.nanoTime();
        System.out.println("sequentialSum : " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        traditionalSum(count);
        end = System.nanoTime();
        System.out.println("traditionalSum : " + (end - start) / 1_000_000 + " ms");

    }

    private static long parallelSum(long l) {
        return Stream.iterate(0L, x -> x + 1)
                .limit(l)
                .parallel()
                .reduce(0L, Long::sum);
    }

    private static long sequentialSum(long l) {
        return Stream.iterate(0L, x -> x + 1)
                .limit(l)
                .sequential()
                .reduce(0L, Long::sum);
    }

    private static long traditionalSum(long l) {
        long sum = 0;
        for (long i = 1L; i <= l; i++) {
            sum += i;
        }
        return sum;
    }
}
