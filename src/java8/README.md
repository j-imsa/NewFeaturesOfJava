# Java 8 (LTS)

<hr>

### Functional Programming

- Imperative style programming
    - what to do?
    - How to do?
- Declarative style programming
    - what to do?
- Higher order function
    - what is a function?
        - Pass objects to a function
        - Create objects within a function
        - Return objects from a function
    - what is the HOF?
        - Pass functions to a function
        - Create function within a function
        - Return function from a function

**Functional programming = Declarative style programming + Higher order function**

<hr>

### Lambda Expression

- Anonymous
    - less to write, and think about
- Function
    - parameters
    - body
    - return type
    - exceptions
    - ...
- Passed around
    - passed as argument
    - stored in a variable
- Concise

#### Before, After

#### Behavior Parameterization

<hr>

### Functional Interface

```
@FunctionalInterface
```

package: java.util.stream (Interface Stream<T>)

- Predicate
- Supplier
- BiConsumer
- ...

| Functional Interface | Function Descriptor | Primitive Specialization                                               |
|----------------------|---------------------|------------------------------------------------------------------------|
| Predicate<T>         | T -> boolean        | IntPredicate<br/>LongPredicate<br/>DoublePredicate                     | 
| Consumer<T>          | T -> void           | IntConsumer<br/>LongConsumer<br/>DoubleConsumer                        |
| Function<T, R>       | T -> R              | IntFunction<R><br/>IntToDoubleFunction<br/>ToDoubleFunction<T><br/>... |
| Supplier<T>          | () -> T             | BooleanSupplier<br/>IntSupplier<br/>...                                |
| UnaryOperator<T>     | T -> T              | IntUnaryOperator<br/>LongUnaryOperator<br/>...                         |
| BinaryOperator<T>    | (T, T) -> T         | IntBinaryOperator<br/>LongBinaryOperator<br/>...                       |
| BiPredicate<L, R>    | (L, R) -> boolean   |                                                                        |
| BiConsumer<T, U>     | (T, U) -> void      | ObjIntConsumer<T><br/>ObjLongConsumer<T><br/>...                       |
| BiFunction<T, U, R>  | (T, U) -> R         | ToIntBiFunction<T, U><br/>ToLongBiFunction<T, U><br/>...               |

References: [Functional Interface (Oracle)](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html), [Interface Stream<T> (Oracle)](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)

<hr>

### Method Reference

#### Before, After

- Static method (Integer::parseInt)
- Instance method (of an arbitrary type like String::length)
- Instance method (of an existing object expensiveTransaction::getValue)

Type 1:

| Lambda                                 | Method Reference       |
|----------------------------------------|------------------------|
| (args) -> ClassName.staticMethod(args) | ClassName.staticMethod |  

Type 2:

| Lambda                                    | Method Reference          |
|-------------------------------------------|---------------------------|
| (arg0, rest) -> arg0.instanceMethod(rest) | ClassName::instanceMethod |  

Type 3:

| Lambda                              | Method Reference     |
|-------------------------------------|----------------------|
| (args) -> expr.instanceMethod(args) | expr::instanceMethod |  

<hr>

### Composing Lambda Expressions

- Comparator
- Predicate
- Functions
- ...

<hr>

### Streams

- Java API
- manipulating collections of data in a declarative way
- query rather than code
- fancy iterators over data collections
- parallel transparency, without multithreaded code
- **stateless vs stateful**

#### Filtering

- filter(Predicate)
    - distinct()
    - limit(int)
    - skip(int)

#### Mapping

- map(Function)
- flatMap()

#### Finding

- anyMatch
- allMatch
- noneMatch
- findFirst -> return Optional
- findAny -> return Optional

#### Reducing

- functional programming term "fold"
- reduce(init value, BinaryOperator< T >)

```java
int sum = numbers.stream().reduce(0, (a, b) -> a + b);
```

- reduce(BinaryOperator< T >)

```java
import java.util.Optional;

Optional<Integer> max = numbers.stream().reduce(Integer::max);
```

#### Sorting

- sort(Comparator) => (T, T) -> int

<hr>

### Numeric Streams

- Hiding boxing cost: mapToInt()
    - int (primitive) -> Integer (Object) : boxing
    - Integer (Object) -> int (primitive) : unboxing

```java
import java.util.stream.IntStream;
import java.util.stream.Stream;

IntStream intStream = Stream.of(1, 2, 3, 4, 5);
Stream<Integer> stream = intStream.boxed();
```

<hr>

### Collecting data with Streams

- Grouping
- Partitioning
- Multilevel groupings

<hr>

### Parallel Streams

```
stream.parallel()
      .filter(...)
      .sequential()
      .map(...)
      .parallel()
      .reduce();
```

<hr>

### Default Methods

- allows static methods inside interfaces
- default implementation for methods

[Google Guava](https://github.com/google/guava) vs [Apache Commons](https://commons.apache.org/)

- Abstract class vs Interface

#### Multilevel inheritance

1. Classes

```java
interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

class B implements A {
    public void hello() {
        System.out.println("Hello from B");
    }
}

class C extends B implements A {
    public static void main(String[] args) {
        new C().hello();
    }
}
```

2. Specific Sub-Interfaces

```java
interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    public static void main(String[] args) {
        new C().hello();
    }
}
```

3. Explicitly Select

```java
interface A {
    default int getNum() {
        return 10;
    }
}

interface B {
    default int getNum() {
        return 20;
    }
}

class C implements A, B {
    public static void main(String[] args) {
        System.out.println(new C().getNum()); // compiler error!
    }
}
```

```java
class C implements A, B {
    public static void main(String[] args) {
        System.out.println(new C().getNum()); // ok!
    }

    public int getNum() {
        return B.super.getNum();
    }
}
```

<hr>

### Optional

- Haskell and Scala
- Cyclomatic complexity

```
return person.getCar().getInsurance().getDate().getYear();
```

```
if(person !=null) {
    Car car = person.getCar();
    if(car !=null){
        Insurance insurance = car.getInsurance();
        if(insurance !=null){
            //...
        }
    }
}
```

- Null vs Java philosophy (hiding pointers)

- Groovy:

```groovy
def carInsuranceName = person?.car?.insurance?.name
```

<hr>

### CompletableFuture

- asynchronous programming
- non-blocking code
- separated thread -> notify main thread
- completion of failure
- Future vs CompletableFuture
    - Java 5
    - isDone()
    - get()
    - limitations:
        - manual completion
        - callback function
        - chain
        - combine multiple futures
        - exception handling

```java
import java.util.concurrent.CompletableFuture;

CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();

String result = stringCompletableFuture.get();
```

<hr>

### New Date Time API

- Challenges
    - ! thread safe
    - ! internationalize
    - ! reflect UTC
    - millisecond granularity
    - random offsets
    - ...

#### Backstory

- James gosling
- JDK 1
- JDK 1.1
- joda-time project

<hr>

### Miscellaneous

- PermGen
    - PermgenOutOfMemoryException
    - removed
- Metaspace memory allocation model
    - out of native memory
- Metaspace capacity
    - MaxMetaspaceSize
- Foreach
    - list, set, queue, map

```
import java.util.Arrays;
import java.util.List;

List<String> names = Arrays.asList("Foo", "Bar");
names.forEach(System.out::println);
```

```
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

Set<String> uniqueNames = new HashSet<>(Arrays.asList("Foo", "Bar"));
uniqueNames.forEach(System.out::println);
```

```
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

Queue<String> namesQueue = new ArrayDeque<>(Arrays.asList("Foo", "Bar"));
namesQueue.forEach(System.out::println);
```
Consumer
```
import java.util.HashMap;
import java.util.Map;

Map<Integer, String> namesMap = new HashMap<>();
namesMap.put(1, "Foo");
namesMap.put(2, "Bar");
namesMap.forEach((key, value) -> System.out.println(key + ": " + value));
```
BiConsumer

