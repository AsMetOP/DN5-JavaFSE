import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AAAPatternTest {
    Calculator calc;

    @BeforeEach
    public void setup() {
        calc = new Calculator();
        System.out.println("Setup: Calculator created");
    }

    @AfterEach
    public void teardown() {
        calc = null;
        System.out.println("Teardown: Calculator destroyed");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calc.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calc.subtract(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 10, b = 2;

        // Act
        int result = calc.divide(a, b);

        // Assert
        assertEquals(5, result);
    }
}