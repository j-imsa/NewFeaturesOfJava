# Java 12

[Oracle](https://www.oracle.com/java/technologies/javase/12-relnote-issues.html), [OpenJDK](https://openjdk.org/projects/jdk/12/)

<hr>

### String Class

- indent
- transform


### Files

- Files::mismatch


### Collectors

- Teeing Collector

```java
Collector<T, ?, R> teeing(
        Collector<? super T, ?, R1> downstream1,
        Collector<? super T, ?, R2> downstream2,
        BiFunction<? super R1, ? super R2, R> merger
);
```


### Number Formater

- CompactNumberFormatter


<hr>

### Other Changes

- Z Garbage Collector (ZGC) (Experimental):
  - A low-pause garbage collector that minimizes application pauses during collection cycles.
- Shenandoah Garbage Collector (Experimental):
  - Shenandoah is a low-pause-time garbage collector that aims to keep pause times independent of heap size.
  - Another garbage collector aiming for low garbage collection overhead.
- Deflate on the Fly: 
  - Improves compression of class data in GZip archives, reducing class loading times.
- Class-Data Sharing (CDS) Archives: 
  - Enables faster application startup by pre-storing optimized JVM class data.
- Microbenchmark Suite
    - A suite of microbenchmarks based on the existing Java Microbenchmark Harness (JMH) is included in the JDK source code.
```java
// Example JMH Benchmark
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class MyBenchmark {
    @Benchmark
    public void testMethod() {
        // Benchmark code here
    }
}
```
- One AArch64 Port, Not Two
  - Consolidates the two AArch64 ports (the 32-bit ARM and 64-bit ARM) into a single port.
  - Streamlines development and maintenance for ARM architecture support in the JDK.
- Abortable Mixed Collections for Garbage-First (G1)
  - Enhancements to the G1 garbage collector make mixed collections abortable if they might exceed the pause time goal.
- Collector Telemetry 
- Pack200 Tools and API Removal
- Immediate Return from Finalization
- Promptly Return Unused Committed Memory from G1
- Unicode 11 Support
- Hidden Class Performance Improvements: Optimizes hidden class creation for anonymous inner classes, potentially improving performance.
- invokedynamic Instruction: Impacts dynamic method calls, potentially leading to better performance in specific scenarios.


<hr>

## PREVIEW CHANGES

```shell
javac -Xlint:preview --enable-preview -source 12 src/main/java/File.java
```

- switch expression
- instanceof
- JVM Constants API
  - Introduces an API to model nominal descriptions of key class-file and run-time artifacts, particularly constants that are loadable from the constant pool.
- Records (Preview)
  - introduced in Java 14, not Java 12

