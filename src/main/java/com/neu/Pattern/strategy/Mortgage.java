package com.neu.Pattern.strategy;

import java.text.DecimalFormat;
import java.util.*;

public abstract class Mortgage extends Observable {
    /** the mortgage strategy */
    private MortgageStrategy strategy;
    /** the initial loan. It's get from the input */
    private double initialLoan;
    /** how much loan left now */
    private double currentLoan;
    /** the interest rate */
    private double interestPoint;
    /** the start date of loan */
    private String startDate;
    /** the end date of loan */
    private String endDate;
    /** the list of payment from the start date to the end date */
    private List<Payment> payments = null;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setStrategy(MortgageStrategy strategy) {
        this.strategy = strategy;
    }

    public MortgageStrategy getStrategy() {
        return strategy;
    }

    public double getInitialLoan() {
        return initialLoan;
    }

    public void setInitialLoan(double initialLoan) {
        this.initialLoan = initialLoan;
    }

    public double getCurrentLoan() {
        return currentLoan;
    }

    public void setCurrentLoan(double currentLoan) {
        this.currentLoan = currentLoan;
    }

    public double getInterestPoint() {
        return interestPoint;
    }

    public void setInterestPoint(double interestPoint) {
        this.interestPoint = interestPoint;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Mortgage() {
    }

    public Mortgage(double initialLoan, double interestPoint, String startDate, String endDate) {
        this.initialLoan = initialLoan;
        this.interestPoint = interestPoint;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Payment getRequiredPayment(String payDate) {
        makePayment();
        DecimalFormat df = new DecimalFormat("#.00");
        Payment payment = null;
        for (Payment p : payments) {
            if (p.getDate().equals(payDate)) {
                payment = p;
            }
        }
        return payment;
    }

    public void makePayment() {
        payments = strategy.calculate(initialLoan, interestPoint, startDate, endDate);
        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

}
