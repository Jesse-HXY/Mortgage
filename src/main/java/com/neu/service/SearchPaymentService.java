package com.neu.service;

import com.neu.Pattern.strategy.Mortgage;
import com.neu.Pattern.strategy.Payment;

import java.util.ArrayList;
import java.util.List;

public class SearchPaymentService {
    public List<Payment> searchPaymentByDate(Mortgage mortgage, String date) {
        List<Payment> payments = new ArrayList<>();
        Payment payment = mortgage.getRequiredPayment(date);
        payments.add(payment);
        return payments;
    }
}
