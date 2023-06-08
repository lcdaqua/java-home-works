package ru.qiwi.payments.dto;

import java.util.Comparator;
import java.util.List;

public class TotalSum {
    private double totalAmount;
    private double totalCommission;
    private String personId;


    public TotalSum(List<Payment> payments) {
        payments.forEach(payment -> totalAmount += payment.getAmount());
        payments.forEach(payment -> totalCommission += payment.getCommission());
    }

    public TotalSum(List<Payment> payments, String personId) {
        payments.forEach(payment -> totalAmount += payment.getAmount());
        payments.forEach(payment -> totalCommission += payment.getCommission());
        this.personId = personId;
    }

    public double getNR() {
        return totalAmount + totalCommission;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public String getPersonId() {
        return personId;
    }
}

