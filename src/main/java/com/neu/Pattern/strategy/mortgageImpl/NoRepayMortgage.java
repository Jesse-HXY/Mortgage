package com.neu.Pattern.strategy.mortgageImpl;

import com.neu.Pattern.strategy.Mortgage;
import com.neu.Pattern.strategy.strategyImpl.NoRepayMortgageStrategy;


/**
 * the no repay mortgage class
 */
public class NoRepayMortgage extends Mortgage {

    public NoRepayMortgage(double initialLoan, double interestPoint, String startDate, String endDate) {
        super(initialLoan, interestPoint, startDate, endDate);
        super.setStrategy(new NoRepayMortgageStrategy());
    }
}
