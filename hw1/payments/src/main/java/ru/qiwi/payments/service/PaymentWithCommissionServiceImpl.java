package ru.qiwi.payments.service;

import org.springframework.stereotype.Service;
import ru.qiwi.payments.dataprovider.PaymentsDataProvider;
import ru.qiwi.payments.dto.PaymentWithCommission;

@Service
public class PaymentWithCommissionServiceImpl extends PaymentAbstract<PaymentWithCommission> {

    private PaymentsDataProvider paymentsDataProvider;

    public PaymentWithCommissionServiceImpl(PaymentsDataProvider paymentsDataProvider) {
        this.paymentsDataProvider = paymentsDataProvider;
        this.function = paymentWithCommission -> paymentWithCommission.getCommission() + paymentWithCommission.getAmount();
        this.supplier = paymentsDataProvider::getPaymentWithCommission;
    }
}
