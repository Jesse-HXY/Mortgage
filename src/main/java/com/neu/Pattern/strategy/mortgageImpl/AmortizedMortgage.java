package com.neu.Pattern.strategy.mortgageImpl;

import com.neu.Pattern.strategy.Mortgage;
import com.neu.Pattern.strategy.strategyImpl.AmortizedMortgageStrategy;

/**
 * the amortized mortgage class
 */
public class AmortizedMortgage extends Mortgage {

    public AmortizedMortgage(double initialLoan, double interestPoint, String startDate, String endDate) {
        super(initialLoan, interestPoint, startDate, endDate);
        super.setStrategy(new AmortizedMortgageStrategy());

    }
}
