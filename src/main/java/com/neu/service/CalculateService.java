package com.neu.service;

import com.neu.Pattern.strategy.Mortgage;
import com.neu.Pattern.strategy.mortgageImpl.AmortizedMortgage;
import com.neu.Pattern.strategy.mortgageImpl.LinearMortgage;
import com.neu.Pattern.strategy.mortgageImpl.NoRepayMortgage;
import com.neu.util.DateCalculate;
import java.util.Date;

public class CalculateService {
    public Mortgage getMortgage(Date startDate, Date endDate, String method, String loan, String rate) {
        double initialLoan = Double.valueOf(loan);
        double interestPoint = Double.valueOf(rate) * 0.01;
        String start = DateCalculate.dateToString(startDate);
        String end = DateCalculate.dateToString(endDate);
        Mortgage mortgage = null;
        switch (method) {
            case "Lineair":
                mortgage = new LinearMortgage(initialLoan, interestPoint, start, end);
                break;

            case "NoRepay":
                mortgage = new NoRepayMortgage(initialLoan, interestPoint, start, end);
                break;

            case "Amortized":
                mortgage = new AmortizedMortgage(initialLoan, interestPoint, start, end);
                break;
        }
        return mortgage;
    }

}
