### Easy Questions

---


1. **What is the new `var` keyword introduced in Java 11?**
    - The `var` keyword allows local variable type inference. It lets the compiler infer the type of the variable based on the value assigned to it.


2. **How can you run a single Java source file directly from the command line in Java 11?**
    - You can use the `java` command to run a single source file directly. For example: `java HelloWorld.java`.


3. **What is the difference between `String::lines` and `BufferedReader::lines` in Java 11?**
    - `String::lines` returns a stream of lines extracted from the string, whereas `BufferedReader::lines` returns a stream of lines read from a `BufferedReader`.


4. **What is the purpose of the `isBlank` method in the `String` class?**
    - The `isBlank` method returns `true` if the string is empty or contains only white space codepoints.


5. **Explain the `strip` method in the `String` class.**
    - The `strip` method removes leading and trailing white spaces from the string, including Unicode white spaces.


6. **What is the difference between `strip` and `trim` methods in the `String` class?**
    - `strip` handles Unicode white spaces, while `trim` only handles ASCII white spaces.


7. **How do you create an immutable collection in Java 11?**
    - You can use the `List.of`, `Set.of`, or `Map.of` methods to create immutable collections.


8. **What is the `repeat` method in the `String` class used for?**
    - The `repeat` method returns a new string whose value is the concatenation of the original string repeated a specified number of times.


9. **Describe the `LocalVariable.get` method introduced in Java 11.**
    - `LocalVariable.get` is a method in the `LocalVariable` class that retrieves the value of the variable.


10. **What enhancements have been made to the `Optional` class in Java 11?**
    - Java 11 introduces the `isEmpty` method to check if an `Optional` is empty, and `Optional::stream` to convert an `Optional` to a stream.

---

### Medium Questions

---

1. **Explain the new `HttpClient` API introduced in Java 11.**
    - The new `HttpClient` API provides a modern and flexible way to perform HTTP requests. It supports synchronous and asynchronous requests, HTTP/2, and WebSocket.


2. **How can you read a file as a string in Java 11?**
    - You can use `Files.readString(Path path)` to read the contents of a file as a string.


3. **What is the purpose of the `Predicate.not` method?**
    - The `Predicate.not` method is a static method that returns a predicate representing the negation of the specified predicate.


4. **Explain the `Collectors::toUnmodifiableList` method.**
    - `Collectors.toUnmodifiableList` returns a `Collector` that accumulates the input elements into an unmodifiable list.


5. **How has the `ZGC` garbage collector been enhanced in Java 11?**
    - ZGC in Java 11 is designed to handle very large heaps (multi-terabyte heaps) with low latency.


6. **What improvements have been made to the `Nest-Based Access Control` in Java 11?**
    - Nest-Based Access Control allows classes that are logically grouped together (nested types) to access each other's private members.


7. **How do you create a new `String` from bytes using the new methods in Java 11?**
    - You can use `String(byte[] bytes, int offset, int length)` to create a new `String` from a byte array.

    
8. **Explain the `Files.writeString` method introduced in Java 11.**
    - `Files.writeString(Path path, CharSequence csq)` writes the specified string to a file.


9. **What is the purpose of the `Key Agreement` API introduced in Java 11?**
    - The `Key Agreement` API allows two parties to securely agree on a shared secret key over an insecure channel.


10. **How has the `JEP 330: Launch Single-File Source-Code Programs` improved Java development?**
    - JEP 330 allows developers to run a single Java source file directly without needing to compile it first, simplifying quick prototyping and scripting. 
    - [JDK Enhancement Proposals](https://openjdk.org/jeps/0)


11. **Describe the `toArray(IntFunction)` method added to the `Collection` interface.**
    - The `toArray(IntFunction)` method allows the creation of an array of the collection's elements using the provided array generator function.


12. **How does the `HttpClient::sendAsync` method work?**
    - `HttpClient::sendAsync` sends an HTTP request asynchronously and returns a `CompletableFuture` that completes with the `HttpResponse`.


13. **Explain the enhancements in `Flight Recorder` in Java 11.**
    - Flight Recorder in Java 11 is now open-sourced and provides detailed profiling and diagnostic data for Java applications.


14. **What is the `Epsilon` garbage collector in Java 11?**
    - Epsilon is a no-op garbage collector that handles memory allocation without reclamation, intended for performance testing and special use cases where GC overhead is unnecessary.


15. **How do you create an unmodifiable copy of a `Map` in Java 11?**
    - You can use `Map.copyOf` to create an unmodifiable copy of the given map.


---

### Hard Questions

---

1. **Explain how the `var` keyword improves type inference in lambda expressions.**
    - The `var` keyword can be used in lambda parameters to enable type annotations, which can improve readability and allow for annotations.


2. **How does the `ZGC` garbage collector achieve low-latency performance?**
    - ZGC achieves low latency by using a coloring mechanism for pointers and concurrent phases that allow most operations to be non-blocking.


3. **What are the security enhancements in the TLS 1.3 implementation in Java 11?**
    - TLS 1.3 improves security with features like zero round-trip time (0-RTT), simplified handshake, and removal of weaker algorithms.


4. **How can the `HttpClient` API be used to handle WebSocket communication in Java 11?**
    - The `HttpClient` API provides a `WebSocket.Builder` to create WebSocket clients, allowing for asynchronous communication with WebSocket servers.


5. **Describe the improvements to the `Lambda Metafactory` in Java 11.**
    - The `Lambda Metafactory` has been optimized for better performance, reducing the overhead of lambda expression creation and execution.


6. **Explain the significance of the `dynamic class-file constants` (JEP 309) in Java 11.**
    - Dynamic class-file constants allow for more flexible and efficient handling of constants in the JVM, improving performance and enabling new features.
    - Dynamic class-file constants is a feature in Java 11 that allows you to define constants in the class file that are determined at runtime. This is in contrast to traditional constants, which are defined at compile time and cannot be changed.


7. **How does the `Nest-Based Access Control (JEP 181)` enhance encapsulation in Java 11?**
    - Nest-Based Access Control allows nested classes to access each other's private members, improving encapsulation and reducing boilerplate code.


8. **What are the advantages of the new `compact number formatting` in Java 11?**
    - Compact number formatting provides a way to format numbers in a more readable, locale-sensitive manner, such as "1K" for 1,000.


9. **How does the `HttpClient` API handle HTTP/2 features in Java 11?**
    - The `HttpClient` API supports multiplexing, header compression, and server push, all features of HTTP/2, improving performance and efficiency.


10. **What changes have been made to the `AArch64` port in Java 11?**
    - The `AArch64` port has been stabilized and improved for better performance and compatibility on ARM architectures.


11. **Describe how the `Switch Expressions` (preview feature) can simplify code in Java 11.**
    - Switch expressions allow switch statements to return values and be used as expressions, reducing boilerplate and increasing readability.


12. **How do you handle raw string literals in Java 11?**
    - Although raw string literals were proposed, they were not included in Java 11. Instead, text blocks were introduced in later versions for multiline strings.


13. **Explain the purpose and usage of the `Pattern.compile` method with flags in Java 11.**
    - `Pattern.compile` compiles a regular expression with optional flags for case insensitivity, multiline mode, etc., for more flexible pattern matching.


14. **How does the `Flight Recorder` API help in performance monitoring?**
    - Flight Recorder records events and metrics from the JVM and application, providing insights for performance tuning and troubleshooting.


15. **Describe the impact of `JEP 321: HTTP Client` on legacy `HttpURLConnection` code.**
    - The new `HttpClient` API replaces the legacy `HttpURLConnection`, offering a more modern, flexible, and performant way to handle HTTP requests.


16. **What are the key benefits of the `String::strip` family of methods?**
    - `strip`, `stripLeading`, and `stripTrailing` provide efficient and Unicode-aware trimming of whitespace characters.


17. **How can `Stack-Walking API` in Java 11 be used for better performance in stack trace analysis?**
    - The `Stack-Walking API` provides a flexible and efficient way to traverse and analyze stack frames, improving performance and capabilities for diagnostics.


18. **What improvements have been made to the `G1 Garbage Collector` in Java 11?**
    - Enhancements to the G1 garbage collector include better performance, lower pause times, and improvements to heap region size selection.


19. **Explain how `JEP 318: Epsilon` is beneficial for certain Java applications.**
    - Epsilon is beneficial for performance testing, short-lived jobs, and other scenarios where GC overhead is unnecessary, providing predictable performance.


20. **How does `JEP 328: Flight Recorder` enhance JVM monitoring?**
    - Flight Recorder provides a detailed and low-overhead event-based profiling and diagnostics framework, aiding in performance tuning and troubleshooting.


21. **Describe the concept of `Key Agreement` and its implementation in Java 11.**
    - Key Agreement allows two parties to securely agree on a shared secret key using algorithms like Diffie-Hellman, providing secure communication channels.


22. **What are the improvements in `Nashorn` in Java 11?**
    - Although Nashorn was deprecated for removal, improvements included better ES6 support and performance optimizations.


23. **Explain the role of `java.lang.invoke` in supporting dynamic languages on the JVM.**
    - `java.lang.invoke` provides low-level primitives for efficient method handle-based invocation, supporting dynamic language features on the JVM.


24. **How does the `ConstantDynamic` feature (JEP 309) enhance JVM capabilities?**
    - `ConstantDynamic` allows constants to be computed at runtime, providing more flexibility and efficiency in class file constant handling.


25. **What are the benefits of the `GC Interface` introduced in Java 11?**
    - The GC Interface allows for better isolation and modularization of garbage collectors, enabling easier experimentation and development of new GCs.


26. **Explain the improvements made to `JEP 329: ChaCha20 and Poly1305 Cryptographic Algorithms`.**
    - These algorithms provide high-performance, secure encryption and authentication, enhancing Java's cryptographic capabilities.


27. **How does the `java.util.concurrent` package in Java 11 improve concurrency handling?**
    - Improvements include better performance, additional utility methods, and enhancements to existing concurrency constructs for better scalability.


28. **Describe the enhancements in `Dynamic Class-File Constants` (JEP 309).**
    - These enhancements improve performance and flexibility in constant pool handling, allowing for more dynamic and efficient constant resolution.


29. **How has the `Class-Data Sharing` feature been improved in Java 11?**
    - Class-Data Sharing now supports application classes, reducing startup time and memory footprint by sharing common class metadata across JVM instances.


30. **What are the key security updates in Java 11?**
    - Security updates include TLS 1.3 support, improvements to the default cryptographic algorithms, and enhancements to the Java security manager.

---
