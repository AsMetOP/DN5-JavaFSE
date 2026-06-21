package com.dn5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedCalculatorTest {
    CalculatorService service = new CalculatorService();

    @ParameterizedTest
    @CsvSource({"1,2,3", "5,5,10", "10,20,30"})
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, service.add(a, b));
    }
}