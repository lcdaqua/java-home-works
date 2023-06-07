package ru.qiwi.payments.dataprovider;

import org.springframework.stereotype.Component;
import ru.qiwi.payments.dto.Payment;

import java.util.Arrays;
import java.util.List;

@Component
public class PaymentsDataProvider {
    public List<Payment> getPayments() {
        return Arrays.asList(

        );
    }
}
