package ru.qiwi.payments.service;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import ru.qiwi.payments.dto.Payment;

public abstract class PaymentAbstract <T extends Payment> implements PaymentService {

    protected Function<T, Integer> function;
    protected Supplier<T[]> supplier;

    @Override
    public int getTotalSum() {
        int sum = 0;
        for (int i = 0; i < getPaymentsCount(); i++) {
            sum += function.apply(supplier.get()[i]);
        }
        return sum;
    }

    @Override
    public int getPaymentsCount() {
        return supplier.get().length;
    }
}
