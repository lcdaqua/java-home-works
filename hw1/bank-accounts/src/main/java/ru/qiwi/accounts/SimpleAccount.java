package ru.qiwi.accounts;

public class SimpleAccount extends BankAccount {

    private double commission = 0.05;

    public SimpleAccount(double amount) {
        super(amount);
    }

    public void getCommission(double sum){
        setAmount(getAmount() - sum * commission);
    }

    @Override
    public void getMoney(double sum) {
        super.getMoney(sum);
        getCommission(sum);
    }
}
