package com.neu.Pattern.strategy;

/**
 * the payment of loan
 */
public class Payment {
    /** the current date */
    private String date;
    /** the repayment of this month */
    private double repayment;
    /** the interest of this month */
    private double interest;
    /** how much loan left */
    private double currentLoan;

    public Payment(double currentLoan, double interest, double repayment, String date) {
        this.date = date;
        this.repayment = repayment;
        this.interest = interest;
        this.currentLoan = currentLoan;
    }

    public Payment(){}

    public void setDate(String date) {
        this.date = date;
    }

    public void setRepayment(double repayment) {
        this.repayment = repayment;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setCurrentLoan(double currentLoan) {
        this.currentLoan = currentLoan;
    }

    public double getCurrentLoan() {
        return currentLoan;
    }

    public double getInterest() {
        return interest;
    }

    public double getRepayment() {
        return repayment;
    }

    public String getDate() {
        return date;
    }
}
