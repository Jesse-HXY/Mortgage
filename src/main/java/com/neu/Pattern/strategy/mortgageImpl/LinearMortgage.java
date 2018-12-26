package com.neu.Pattern.strategy.mortgageImpl;

import com.neu.Pattern.strategy.Mortgage;
import com.neu.Pattern.strategy.strategyImpl.LinearMortgageStrategy;


/**
 * the linear mortgage class
 */
public class LinearMortgage extends Mortgage {
    public LinearMortgage(double initialLoan, double interestPoint, String startDate, String endDate) {
        super(initialLoan, interestPoint, startDate, endDate);
        super.setStrategy(new LinearMortgageStrategy());
    }

}
