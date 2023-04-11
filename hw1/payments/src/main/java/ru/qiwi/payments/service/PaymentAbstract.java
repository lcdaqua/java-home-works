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
        return Arrays.stream(supplier.get()).mapToInt(payment -> function.apply(payment)).sum();
    }

    @Override
    public int getPaymentsCount() {
        return supplier.get().length;
    }
}
