package ru.qiwi.payments.dto;

import java.util.Comparator;

public class TotalSumComparator implements Comparator<TotalSum> {

    @Override
    public int compare(TotalSum first, TotalSum second) {
        return Double.compare(first.getTotalAmount(), second.getTotalAmount());
    }
}
