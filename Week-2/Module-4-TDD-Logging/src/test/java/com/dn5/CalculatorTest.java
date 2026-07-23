package com.dn5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("Starting Calculator Tests");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All Calculator Tests Completed");
    }

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test finished");
    }

    @Test
    @DisplayName("Test Addition")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    @DisplayName("Test Subtraction")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-2, calculator.subtract(-1, 1));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    @DisplayName("Test Multiplication")
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-15, calculator.multiply(3, -5));
    }

    @Test
    @DisplayName("Test Division")
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(3.0, calculator.divide(9, 3));
    }

    @Test
    @DisplayName("Test Division By Zero")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    @Test
    @DisplayName("Test Add Returns Positive")
    void testAddPositive() {
        assertTrue(calculator.add(2, 3) > 0);
    }

    @Test
    @DisplayName("Test Multiply Not Null")
    void testMultiplyNotNull() {
        assertNotNull(calculator.multiply(2, 3));
    }
}
