package ru.qiwi.payments.comparators;

import ru.qiwi.payments.dto.Payment;

import java.util.Comparator;

public class PaymentDataComparator implements Comparator<Payment> {

    @Override
    public int compare(Payment firstPayment, Payment secondPayment) {
        return firstPayment.getDate().compareTo(secondPayment.getDate());
    }
}
