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

```java
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

| Lambda                                    | Method Reference          |
|-------------------------------------------|---------------------------|
| (args) -> ClassName.staticMethod(args)    | ClassName.staticMethod    |  


Type 2:

| Lambda                                    | Method Reference          |
|-------------------------------------------|---------------------------|
| (arg0, rest) -> arg0.instanceMethod(rest) | ClassName::instanceMethod |  


Type 3:

| Lambda                                    | Method Reference          |
|-------------------------------------------|---------------------------|
| (args) -> expr.instanceMethod(args)       | expr::instanceMethod      |  


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


