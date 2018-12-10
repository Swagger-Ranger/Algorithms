package com.test;

import com.junit.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int c = calculator.add(1, 2);
        assertEquals(3, c);
    }
}