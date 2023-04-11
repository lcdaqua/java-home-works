package ru.qiwi.payments.dto;

import java.util.Arrays;

public class PaymentWithCommission extends Payment {

    private final int commission;

    public PaymentWithCommission(int amount, int commission) {
        super(amount);
        this.commission = commission;
    }

    public int getCommission() {
        return commission;
    }
}
