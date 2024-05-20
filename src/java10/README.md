# Java 10

<hr>

### Var

- Local variable type inference
- ! instance variable
- method local variable
- ! keyword
  - backward compatibility

```java
import java.util.HashMap;

HashMap<String, Integer> stringIntegerHashMap1 = new HashMap<>();
var stringIntegerHashMap2 = new HashMap<String, Integer>();
```

<hr>

### copyOf()

- `java.util.List`
- `java.util.Map`
- `java.util.Set`
  - ava.lang.UnsupportedOperationException

<hr>

### Container Awareness

- JVMs are now aware of being run in a docker containers
- Extract container-specific configuration instead of querying the OS itself
- `-XX:-UseContainerSupport`
- ...
