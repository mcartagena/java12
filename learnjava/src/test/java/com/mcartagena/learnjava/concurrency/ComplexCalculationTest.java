package com.mcartagena.learnjava.concurrency;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class ComplexCalculationTest {

    @Test
    public void shouldcalculateResult() {

        BigInteger complexCalculation = new ComplexCalculation().calculateResult(
                BigInteger.valueOf(3),
                BigInteger.valueOf(10),
                BigInteger.valueOf(2),
                BigInteger.valueOf(6));

        assertEquals(complexCalculation.compareTo(BigInteger.valueOf(59113)), 0);

    }
}