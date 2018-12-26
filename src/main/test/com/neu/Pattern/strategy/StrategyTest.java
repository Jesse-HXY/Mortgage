package com.neu.Pattern.strategy;

import com.neu.Pattern.observer.MortgageObserver;
import com.neu.Pattern.strategy.mortgageImpl.AmortizedMortgage;
import com.neu.Pattern.strategy.mortgageImpl.LinearMortgage;
import com.neu.Pattern.strategy.mortgageImpl.NoRepayMortgage;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;


public class StrategyTest {
    DecimalFormat df = new DecimalFormat("#.00");

    /**
     * test for the makePayment method of linearMortgageStrategy
     */
    @Test
    public void LinearMortgageStrategyTest() {

        Mortgage linearMortgage = new LinearMortgage(100000.00, 0.015, "2017-01", "2047-01");
        MortgageObserver mortgageObserver = new MortgageObserver(linearMortgage);
        linearMortgage.makePayment();
        List<Payment> list = linearMortgage.getPayments();
        Payment test_payment = list.get(list.size() - 1);
        Assert.assertEquals(Double.valueOf("277.78"), Double.valueOf(df.format(test_payment.getCurrentLoan())));
        Assert.assertEquals(Double.valueOf("4.17"), Double.valueOf(df.format(test_payment.getInterest())));
        Assert.assertEquals("2046-12", test_payment.getDate());
        Assert.assertEquals(Double.valueOf("277.78"), Double.valueOf(df.format(test_payment.getRepayment())));
    }

    /**
     * test for the makePayment method of NoRepayMortgageStrategyTest
     */
    @Test
    public void NoRepayMortgageStrategyTest() {

        Mortgage noRepayMortgage = new NoRepayMortgage(100000.00, 0.015, "2017-01", "2047-01");
        MortgageObserver mortgageObserver = new MortgageObserver(noRepayMortgage);
        noRepayMortgage.makePayment();
        List<Payment> list = noRepayMortgage.getPayments();
        Payment test_payment = list.get(list.size() - 1);
        Assert.assertEquals(Double.valueOf("100000.00"), Double.valueOf(df.format(test_payment.getCurrentLoan())));
        Assert.assertEquals(Double.valueOf("1500.00"), Double.valueOf(df.format(test_payment.getInterest())));
        Assert.assertEquals("2046-12", test_payment.getDate());
        Assert.assertEquals(Double.valueOf("100000.00"), Double.valueOf(df.format(test_payment.getRepayment())));
    }

    /**
     * test for the makePayment method of AmortizedMortgageStrategyTest
     */
    @Test
    public void AmortizedMortgageStrategyTest() {
        Mortgage amortizedMortgage = new AmortizedMortgage(100000.00, 0.015, "2017-01", "2047-01");
        MortgageObserver mortgageObserver = new MortgageObserver(amortizedMortgage);
        amortizedMortgage.makePayment();
        List<Payment> list = amortizedMortgage.getPayments();
        Payment test_payment = list.get(list.size() - 1);
        Assert.assertEquals(Double.valueOf("1484.81"), Double.valueOf(df.format(test_payment.getCurrentLoan())));
        Assert.assertEquals(Double.valueOf("22.27"), Double.valueOf(df.format(test_payment.getInterest())));
        Assert.assertEquals(Double.valueOf("1484.81"), Double.valueOf(df.format(test_payment.getRepayment())));
        Assert.assertEquals("2046-12", test_payment.getDate());
    }
}
