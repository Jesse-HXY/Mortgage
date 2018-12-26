package com.neu.Pattern.strategy;

import java.util.List;

/**
 * the mortgage behavoir of Mortgage
 */
public interface MortgageStrategy {

    List<Payment> calculate(double Loan, double interestPoint, String startDate, String endDate);
}
