package ru.qiwi.payments.comparators;

import ru.qiwi.payments.dto.TotalSum;

import java.util.Comparator;

public class TotalSumComparator implements Comparator<TotalSum> {

    @Override
    public int compare(TotalSum first, TotalSum second) {
        return Double.compare(first.getTotalAmount(), second.getTotalAmount());
    }
}
