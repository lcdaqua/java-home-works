package ru.qiwi.payments.service;

import ru.qiwi.payments.dto.TotalSum;

public interface PaymentService {
    TotalSum getTotalSum();

    int getPaymentsCount();
}
