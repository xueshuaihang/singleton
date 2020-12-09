package com.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

//    @BeforeEach
//
//    @AfterEach
//
//    @BeforeAll
//
//    @AfterAll

    @Test
    @Disabled
    void fact() {
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
//        assertEquals(2432902008176640000L, Factorial.fact(21));
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisabledOnJre(JRE.JAVA_8)
    void testNegative() {
        assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Factorial.fact(21);
            }
        });
    }
}