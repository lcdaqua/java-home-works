package ru.qiwi.payments.dto;

import java.time.LocalDateTime;

public class Payment {
    private final int id;
    private final LocalDateTime date;
    private final Status status;
    private final String fromAccount;
    private final String toAccount;
    private final double amount;
    private final double commission;
    private final MerchantType merchantType;

    public enum MerchantType {
        SHOP, P2P
    }

    public enum Status {
        IN_PROGRESS, ERROR, OK
    }

    public Payment(
            int id,
            LocalDateTime date,
            double amount,
            double commission,
            String fromAccount,
            String toAccount,
            MerchantType merchantType,
            Status status
    ) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.commission = commission;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.merchantType = merchantType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public double getCommission() {
        return commission;
    }

    public MerchantType getMerchantType() {
        return merchantType;
    }
}
