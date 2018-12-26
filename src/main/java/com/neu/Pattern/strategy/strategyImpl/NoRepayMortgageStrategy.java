package com.neu.Pattern.strategy.strategyImpl;

import com.neu.Pattern.strategy.MortgageStrategy;
import com.neu.Pattern.strategy.Payment;
import com.neu.util.DateCalculate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * the specified behavoir of mortgage. In this strategy, there is no repayment until the last month.
 */
public class NoRepayMortgageStrategy implements MortgageStrategy {

    /**
     * calculate the interest and the repayment of MortgageStrategy each month and generate a list of Payment
     * @param Loan:the initial loan
     * @param interestPoint:the rate of interest
     * @param startDate:the start date of loan
     * @param endDate:the end date of loan
     * @return paymentList: the list of MortgageStrategy of each month
     */
    @Override
    public List<Payment> calculate(double Loan, double interestPoint, String startDate, String endDate) {
        int month = 0;
        try {
            //calculate how money month between the start date and the end date
            month = DateCalculate.calculatedMonth(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //calculate the interest
        double interest = interestPoint * Loan;
        List<Payment> paymentList = new ArrayList<>();
        String date = startDate;
        for (int i = 0; i < month; i++) {
            Payment payment = new Payment(Loan, interest, 0, date);
            //increase date
            date = DateCalculate.increaseMonth(date);
            //add payment into list
            paymentList.add(payment);
        }
        //set the last month repayment
        paymentList.get(paymentList.size() - 1).setRepayment(Loan);
        return paymentList;
    }
}
