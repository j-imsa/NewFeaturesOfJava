### Questions

1. **Explain the `var` keyword introduced in Java 10. How does it enhance type inference? Can you provide an example of
   its usage and discuss any potential pitfalls?**


2. **How does the Local-Variable Type Inference feature impact the readability and maintainability of Java code? What
   are some best practices for using `var`?**


3. **Discuss the changes and enhancements made to the Garbage Collection (GC) in Java 10. What are the key improvements
   and their benefits?**


4. **What is the application class-data sharing (AppCDS) feature introduced in Java 10? How does it work, and what are
   its advantages?**


5. **Java 10 introduced the `Unmodifiable Collections` feature. How does this differ from
   the `Collections.unmodifiableList` method? Provide examples of how to create an unmodifiable list in Java 10.**


6. **Explain the enhancements made to the Java Management Extensions (JMX) in Java 10. How do these improvements benefit
   Java applications?**


7. **Java 10 included enhancements to the `Thread` API. What are these enhancements, and how do they improve
   multithreading in Java?**


8. **Discuss the root certificates inclusion in Java 10. Why was this change significant, and how does it impact Java
   developers?**


9. **Describe the improvements to container awareness in Java 10. How do these changes benefit Java applications running
   in containerized environments?**


10. **What are the implications of the time-based release versioning scheme introduced with Java 10? How does this
    affect the development and deployment of Java applications?**


11. **unmodifiable vs immutable**

### Answers

1. **`var` Keyword:**
   The `var` keyword in Java 10 allows for local variable type inference. Instead of explicitly specifying the type of a
   local variable, you can use `var` and let the compiler infer the type based on the initializer.

   ```java
   var list = new ArrayList<String>(); // inferred as ArrayList<String>
   ```

   **Potential pitfalls:**
    - **Reduced readability:** Overuse of `var` can make code less readable, especially when the inferred type is not
      immediately obvious.
    - **Maintainability:** It may be harder to understand the type when reading code later, especially in large
      codebases.


2. **Impact on Readability and Maintainability:**
    - **Readability:** `var` can make code more concise, but should be used where the type is evident from the context
      to avoid confusion.
    - **Best Practices:**
        - Use `var` when the type is obvious from the initializer.
        - Avoid using `var` for complex or ambiguous types.
        - Document code appropriately to maintain clarity.


3. **Garbage Collection Enhancements:**
   Java 10 introduced improvements to the G1 Garbage Collector, making it the default GC. These improvements included
   better parallel full GC and heap region resizing, which enhanced performance and predictability.


4. **Application Class-Data Sharing (AppCDS):**
   AppCDS allows sharing of common class metadata across different Java processes, reducing startup time and memory
   footprint. It works by creating a shared archive file of class data that can be loaded by multiple JVM instances.


5. **Unmodifiable Collections:**
   Java 10 provided convenient factory methods to create unmodifiable collections:

   ```java
   List<String> list = List.of("a", "b", "c"); // unmodifiable list
   ```

   **Difference from `Collections.unmodifiableList`:**
    - `List.of` creates an immutable list directly.
    - `Collections.unmodifiableList` wraps an existing list in an unmodifiable view.


6. **JMX Enhancements:**
   Java 10 improved the monitoring and management capabilities of JMX by updating the `com.sun.management` APIs. This
   included better diagnostic commands and logging features, aiding in more effective management of Java applications.


7. **Thread API Enhancements:**
   Java 10 introduced the `Thread.onSpinWait` method, allowing JVMs to better optimize spin-wait loops, improving the
   efficiency of busy-waiting threads.


8. **Root Certificates Inclusion:**
   Java 10 included a default set of root certificates in the JDK, simplifying the configuration of secure
   communications. This change enhanced security and ease of use for developers.


9. **Container Awareness Improvements:**
   Java 10 improved container awareness, allowing Java applications to recognize and adapt to resource limits in
   containerized environments, such as Docker. This included enhancements to memory and CPU constraints detection.


10. **Time-Based Release Versioning:**
    The time-based release versioning scheme introduced a predictable six-month release cycle for Java versions. This
    change helped developers plan updates and manage dependencies more effectively, but also required more frequent
    testing and adaptation to new releases.


11. Unmodifiable and immutable collections in Java are concepts that deal with the immutability of collections, but they
    are not identical. Here are the key differences between them:

### Unmodifiable Collections

1. **Definition:**
    - An unmodifiable collection is a collection that cannot be modified through its reference. However, if the
      underlying collection is modified through another reference, those changes will be reflected in the unmodifiable
      collection.


2. **Creation:**
    - Unmodifiable collections can be created using methods
      like `Collections.unmodifiableList`, `Collections.unmodifiableSet`, and `Collections.unmodifiableMap`.


3. **Behavior:**
    - An attempt to modify an unmodifiable collection through its reference (e.g., adding, removing elements) will
      result in an `UnsupportedOperationException`.
    - The underlying collection can still be modified if you have another reference to it.


4. **Example:**

```java
    import java.util.List;

    List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
    List<String> unmodifiableList = Collections.unmodifiableList(list);
    
    // This will throw UnsupportedOperationException
    // unmodifiableList.add("D");
    
    // Modifying the original list
    list.add("D");
    System.out.println(unmodifiableList); // Prints [A, B, C, D]
```

### Immutable Collections

1. **Definition:**
    - An immutable collection is a collection whose contents cannot be changed after it is created. This means no
      modifications are possible, and the collection itself cannot be altered in any way.


2. **Creation:**
    - Immutable collections can be created using factory methods like `List.of`, `Set.of`, and `Map.of` in Java 9 and
      later.
    - Immutable collections can also be created using third-party libraries like Guava.


3. **Behavior:**
    - An immutable collection does not allow any modifications. Any attempt to modify it will result in
      an `UnsupportedOperationException`.
    - The internal data structure is not exposed, ensuring that it remains immutable.


4. **Example:**

```java
   import java.util.List;

List<String> immutableList = List.of("A", "B", "C");

// This will throw UnsupportedOperationException
// immutableList.add("D");

// The original list is immutable and cannot be modified
// immutableList = Arrays.asList("A", "B", "C");
```

### Key Differences

- **Modification:**
    - **Unmodifiable:** The collection itself cannot be modified through its reference, but the underlying collection
      can be modified if another reference exists.
    - **Immutable:** The collection cannot be modified at all after creation. No modifications are possible, and the
      collection's state is fixed.


- **Use Case:**
    - **Unmodifiable:** Useful when you want to provide a read-only view of a collection, while still allowing
      modifications to the underlying collection.
    - **Immutable:** Suitable when you want to guarantee that a collection remains constant and unchanged, ensuring
      thread-safety and avoiding defensive copying.


- **Implementation:**
    - **Unmodifiable:** Achieved by wrapping an existing collection.
    - **Immutable:** Created from the start as an immutable collection, usually via factory methods or libraries.


