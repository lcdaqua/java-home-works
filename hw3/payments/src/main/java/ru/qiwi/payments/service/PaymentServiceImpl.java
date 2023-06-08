package ru.qiwi.payments.service;

import org.springframework.stereotype.Service;
import ru.qiwi.payments.dataprovider.PaymentsDataProvider;
import ru.qiwi.payments.dto.Payment;
import ru.qiwi.payments.dto.TotalSum;
import ru.qiwi.payments.dto.TotalSumComparator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl {

    private PaymentsDataProvider paymentsDataProvider;

    public PaymentServiceImpl(PaymentsDataProvider paymentsDataProvider) {
        this.paymentsDataProvider = paymentsDataProvider;
    }

    // должен вернуть объект TotalSum, который содержит сумму всех списаний
    // и сумму всех пополнений для пользователя с personId
    public TotalSum getTotalSum(String personId) {
        return new TotalSum(
                paymentsDataProvider
                        .getPayments()
                        .stream()
                        .filter(x -> x.getFromAccount().equals(personId))
                        .collect(Collectors.toList())
        );
    }

    // должен вернуть количество платежей, совершенных пользователем
    // фильтры на статус платежа и тип мерчанта
    public long getPaymentsCount(String personId, Payment.Status status, Payment.MerchantType merchantType) {
        return paymentsDataProvider.getPayments()
                .stream()
                .filter(x -> x.getFromAccount().equals(personId))
                .filter(x -> x.getMerchantType().equals(merchantType))
                .filter(x -> x.getStatus().equals(status))
                .count();
    }

    // все пополнения пользователя(сортировка по дате)
    public List<Payment> getAllReplenishments() {
        return paymentsDataProvider.getPayments()
                .stream()
                .sorted(new PaymentDataComparator())
                .collect(Collectors.toList());
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
                .filter(x -> x.getFromAccount().equals(personId))
                .filter(x -> x.getMerchantType().equals(merchantType))
                .filter(x -> x.getDate().isAfter(dateFrom) & x.getDate().isBefore(dateTill))
                .sorted(new PaymentDataComparator())
                .collect(Collectors.toList());
    }

    // NR(сумма комиссий) за период по мерчанту
    public double getNRCommission(
            LocalDateTime dateFrom,
            LocalDateTime dateTill,
            Payment.MerchantType merchantType
    ) {
        return new TotalSum(
                paymentsDataProvider
                        .getPayments()
                        .stream()
                        .filter(x -> x.getMerchantType().equals(merchantType))
                        .filter(x -> x.getDate().isAfter(dateFrom) & x.getDate().isBefore(dateTill))
                        .collect(Collectors.toList()))
                .getTotalCommission();
    }

    // Оборот за период по мерчанту
    public double getNR(
            LocalDateTime dateFrom,
            LocalDateTime dateTill,
            Payment.MerchantType merchantType
    ) {
        return new TotalSum(
                paymentsDataProvider
                        .getPayments()
                        .stream()
                        .filter(x -> x.getMerchantType().equals(merchantType))
                        .filter(x -> x.getDate().isAfter(dateFrom) & x.getDate().isBefore(dateTill))
                        .collect(Collectors.toList()))
                .getNR();
    }

    // топ 10 пользователей по обороту(списания + пополнения) за период, сортированый список
    public List <String> getTopUsers(
            LocalDateTime dateFrom,
            LocalDateTime dateTill
    ) {
        Set <String> users = new HashSet<>();
        List <TotalSum> totalSums = new ArrayList<>();
        List <String> topUsers = new ArrayList<>();

        paymentsDataProvider
                .getPayments()
                .stream()
                .filter(x -> x.getDate().isAfter(dateFrom) & x.getDate().isBefore(dateTill))
                .forEach(payment -> {
                    users.add(payment.getFromAccount());
                    users.add(payment.getToAccount());
                });

        for (String user: users) {
            totalSums.add(new TotalSum(paymentsDataProvider.getPayments().stream()
                    .filter(x -> x.getDate().isAfter(dateFrom) & x.getDate().isBefore(dateTill))
                    .filter(x -> x.getFromAccount().equals(user) & x.getToAccount().equals(user))
                    .collect(Collectors.toList()), user));
        }

        totalSums = totalSums.stream().sorted(new TotalSumComparator()).collect(Collectors.toList());



        for (int i = 0; i < 10; i++) {
            topUsers.add(totalSums.get(i).getPersonId());
        }

        return topUsers;
    }
}

class PaymentDataComparator implements Comparator <Payment> {

    @Override
    public int compare(Payment firstPayment, Payment secondPayment) {
        return firstPayment.getDate().compareTo(secondPayment.getDate());
    }
}
