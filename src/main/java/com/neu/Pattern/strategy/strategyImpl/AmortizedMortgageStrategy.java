package com.neu.Pattern.strategy.strategyImpl;

import com.neu.Pattern.strategy.MortgageStrategy;
import com.neu.Pattern.strategy.Payment;
import com.neu.util.DateCalculate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * the specified behavoir of mortgage. In this strategy, every month pay the same amount of money(interest + repayment)
 */
public class AmortizedMortgageStrategy implements MortgageStrategy {

    /**
     * calculate the interest and the repayment of AmortizedMortgage each month and generate a list of Payment
     * @param Loan:the initial loan
     * @param interestPoint:the rate of interest
     * @param startDate:the start date of loan
     * @param endDate:the end date of loan
     * @return paymentList: the list of AmortizedMortgage payment of each month
     */
    @Override
    public List<Payment> calculate(double Loan, double interestPoint, String startDate, String endDate) {

        int month = 0;
        try {
            //get how many month between start date and end date
            month = DateCalculate.calculatedMonth(startDate, endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Payment> paymentList = new ArrayList<>();
        //calculate how much loan need to pay(interest + repayment)
        double theMonthPay = (Loan * interestPoint * Math.pow((1 + interestPoint), month)) / ((Math.pow((1 + interestPoint), month)) - 1);
        double repayment;
        double interest;
        /** current date */
        String date = startDate;
        for (int i = 0; i < month; i++) {
            //calculate interest
            interest = Loan * interestPoint;
            //calculate repayment
            repayment = theMonthPay - interest;
            Payment payment = new Payment(Loan, interest, repayment, date);
            //increase the date
            date = DateCalculate.increaseMonth(date);
            //calculate the loan
            Loan -= repayment;
            //add the payment into payment list
            paymentList.add(payment);
        }
        return paymentList;
    }
}
