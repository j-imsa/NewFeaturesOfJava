package java9;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class ProcessAPI {
    public static void main(String[] args) {
        ProcessHandle handle = ProcessHandle.current();
        System.out.println(handle.pid());
        ProcessHandle.Info info = handle.info();
        Optional<String[]> arguments = info.arguments();
        Optional<Instant> starTime = info.startInstant();
        Optional<Duration> cpUsage = info.totalCpuDuration();
    }
}
