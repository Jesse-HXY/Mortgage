package com.neu.Pattern.strategy;

import com.neu.Pattern.observer.MortgageObserver;
import com.neu.Pattern.strategy.mortgageImpl.AmortizedMortgage;
import com.neu.Pattern.strategy.mortgageImpl.LinearMortgage;
import com.neu.Pattern.strategy.mortgageImpl.NoRepayMortgage;

import java.text.DecimalFormat;
import java.util.List;

public class MortgageCustomerInfoApp {
    public static void main(String[] args) {
        Mortgage mortgage = new LinearMortgage(100000.00, 0.015, "2017-01", "2047-01");
        MortgageObserver mortgageObserver = new MortgageObserver(mortgage);
        mortgage.makePayment();
        List<Payment> list = mortgage.getPayments();
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Date\t\tOutstanding loan\t\tInterest\t\tRepayment\t\tPay per month\t\t");
        for (Payment p : list) {
            System.out.println(
                    p.getDate()+"\t\t\t"+ df.format(p.getCurrentLoan()) + "\t\t\t" + df.format(p.getInterest()) + "\t\t\t"
                            + df.format(p.getRepayment()) + "\t\t\t" + df.format(p.getRepayment() + p.getInterest()) + "\t\t\t");
        }

    }
}
