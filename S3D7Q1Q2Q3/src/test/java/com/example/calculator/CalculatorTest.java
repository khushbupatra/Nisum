package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calc.add(5, 5));
        assertNotEquals(12, calc.add(5, 5));
    }

    @Test
    void testSubtraction() {
        assertEquals(3, calc.subtract(5, 2));
        assertNotEquals(4, calc.subtract(5, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, calc.multiply(4, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2, calc.divide(10, 5));
    }

    @Test
    void testDivisionByZeroThrowsException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
