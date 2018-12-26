package com.neu.util;


import org.junit.Test;


import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class DateCalculateTest {
    /**
     * test for CalculatedMonth()
     */
    @Test
    public void CalculatedMonthTest() {
        try {
            assertEquals(12, DateCalculate.calculatedMonth("2017-01", "2018-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * test for increaseMonth()
     */
    @Test
    public void increaseMonthTest() {
        assertEquals("2018-02", DateCalculate.increaseMonth("2018-01"));

    }
}
