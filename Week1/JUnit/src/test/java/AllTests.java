import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CalculatorTest.class, EvenCheckerTest.class, AssertionsTest.class})
public class AllTests {
}