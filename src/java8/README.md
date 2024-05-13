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
















