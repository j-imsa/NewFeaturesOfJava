# Java 9

[Oracle](https://www.oracle.com/java/technologies/javase/9-all-relnotes.html), [OpenJDK](https://openjdk.org/projects/jdk9/)

<hr>

### Modules

- rt.jar
- [OSGI](https://www.osgi.org/resources/where-to-start/)
- Rules:
  - `java.base`
  - no cycles
  - unique name
  - ...
- implementation
  - public
  - export
  - requires
- module-info.java
- B -> A, C -> B, C -> A
  - external libs
  - monolith into modules

#### Jlink

- command line tool
- creating stripped down binaries
- limited capabilities


<hr>

### Process API

- operating system process
- `java.lang.ProcessHandle`

<hr>

### Private Method in Interfaces

- lengthy


<hr>

### JShell

- REPL
  - read-eval-print-loop
  - /exit

<hr>

### Miscellaneous

- Migration to Modularization
- [Project Jigsaw](https://openjdk.org/projects/jigsaw/) Goals
- Compact Strings in Java 9
- Security Enhancements in Java 9
- Deprecation and Removals in Java 9

