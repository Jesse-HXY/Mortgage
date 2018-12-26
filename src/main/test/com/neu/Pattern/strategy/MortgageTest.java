package com.neu.Pattern.strategy;

import com.neu.Pattern.strategy.mortgageImpl.LinearMortgage;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;

public class MortgageTest {
    DecimalFormat df = new DecimalFormat("#.00");

    /**
     * test for getRequiredPayment()
     */
    @Test
    public void getRequiredPaymentTest() {
        Mortgage mortgage = new LinearMortgage(100000.00, 0.015, "2017-01", "2047-01");
        Payment payment = mortgage.getRequiredPayment("2017-01");
        Assert.assertEquals(Double.valueOf("100000.0"),Double.valueOf(payment.getCurrentLoan()));
        payment = mortgage.getRequiredPayment("2046-12");
        Assert.assertEquals(Double.valueOf("277.78"),Double.valueOf(df.format(payment.getCurrentLoan())));
    }

}
