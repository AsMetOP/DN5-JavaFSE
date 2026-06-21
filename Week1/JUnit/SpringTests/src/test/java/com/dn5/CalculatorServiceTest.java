package com.dn5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorServiceTest {
    @Autowired
    CalculatorService calculatorService;

    @Test
    public void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }
}