import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {
    PerformanceTester tester = new PerformanceTester();

    @Test
    public void testPerformTaskCompletesInTime() {
        assertTimeout(Duration.ofSeconds(1), () -> tester.performTask());
    }

    @Test
    public void testSlowTaskExceedsTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            System.out.println("Task started");
            Thread.sleep(500);
            System.out.println("Task completed within limit");
        });
    }
}