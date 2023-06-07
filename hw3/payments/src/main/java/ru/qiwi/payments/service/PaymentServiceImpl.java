package ru.qiwi.payments.service;

import org.springframework.stereotype.Service;
import ru.qiwi.payments.dataprovider.PaymentsDataProvider;
import ru.qiwi.payments.dto.Payment;
import ru.qiwi.payments.dto.TotalSum;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentServiceImpl {

    private PaymentsDataProvider paymentsDataProvider;

    public PaymentServiceImpl(PaymentsDataProvider paymentsDataProvider) {
        this.paymentsDataProvider = paymentsDataProvider;
    }

    // должен вернуть объект TotalSum, который содержит сумму всех списаний
    // и сумму всех пополнений для пользователя с personId
    public TotalSum getTotalSum(String personId) {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }

    // должен вернуть количество платежей, совершенных пользователем
    // фильтры на статус платежа и тип мерчанта
    public int getPaymentsCount(String personId, Payment.Status status, Payment.MerchantType merchantType) {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }

    // все пополнения пользователя(сортировка по дате)
    public List<Payment> getAllReplenishments() {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }

    // все платежи пользователя за период(сортировка по дате)
    public List<Payment> getPayments(
            String personId,
            Payment.MerchantType merchantType,
            LocalDateTime dateFrom,
            LocalDateTime dateTill
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }

    // NR(сумма комиссий) за период по мерчанту
    public int getNR(
            LocalDateTime dateFrom,
            LocalDateTime dateTill,
            Payment.MerchantType merchantType
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }

    // Оборот за период по мерчанту
    public int getNR(
            LocalDateTime dateFrom,
            LocalDateTime dateTill,
            Payment.MerchantType merchantType
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }

    // топ 10 пользователей по обороту(списания + пополнения) за период, сортированый список
    public List<String> getTopUsers(
            LocalDateTime dateFrom,
            LocalDateTime dateTill
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }
}
