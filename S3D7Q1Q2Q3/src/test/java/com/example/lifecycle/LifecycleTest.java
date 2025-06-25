package com.example.lifecycle;

import org.junit.jupiter.api.*;

public class LifecycleTest {

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println(" BeforeAll: Executed once before all tests.");
    }

    @BeforeEach
    void setupBeforeEach() {
        System.out.println(" BeforeEach: Runs before every test.");
    }

    @Test
    void testOne() {
        System.out.println(" Test One: Running test case 1.");
        Assertions.assertTrue(true);
    }

    @Test
    void testTwo() {
        System.out.println(" Test Two: Running test case 2.");
        Assertions.assertEquals(5, 2 + 3);
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println(" AfterEach: Runs after every test.");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println(" AfterAll: Executed once after all tests.");
    }
}
