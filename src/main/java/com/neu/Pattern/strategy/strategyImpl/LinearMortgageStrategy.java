package com.neu.Pattern.strategy.strategyImpl;

import com.neu.Pattern.strategy.MortgageStrategy;
import com.neu.Pattern.strategy.Payment;
import com.neu.util.DateCalculate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * the specified behavoir of mortgage. In this strategy, the repayment is always same.
 */
public class LinearMortgageStrategy implements MortgageStrategy {

    /**
     * calculate the interest and the repayment of LinearMortgage each month and generate a list of Payment
     * @param Loan:the initial loan
     * @param interestPoint:the rate of interest
     * @param startDate:the start date of loan
     * @param endDate:the end date of loan
     * @return paymentList: the list of LinearMortgage payment of each month
     */
    @Override
    public List<Payment> calculate(double Loan, double interestPoint, String startDate, String endDate) {
        int month = 0;
        try {
            //calculate how many month between the start date and the end date
            month = DateCalculate.calculatedMonth(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //calculate the repayment
        double repayment = Loan / (month);
        double interest;
        List<Payment> paymentList = new ArrayList<>();
        String date = startDate;
        for (int i = 0; i < month; i++) {
            //calculate the interest
            interest = Loan * interestPoint;
            Payment payment = new Payment(Loan, interest, repayment, date);
            //increase date
            date = DateCalculate.increaseMonth(date);
            //calculate how much loan left
            Loan -= repayment;
            //add payment into list
            paymentList.add(payment);
        }
        return paymentList;
    }
}
