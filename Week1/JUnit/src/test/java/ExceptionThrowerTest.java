import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {
    ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowException() {
        assertThrows(IllegalArgumentException.class, () -> thrower.throwException());
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> thrower.divide(10, 0));
    }
}