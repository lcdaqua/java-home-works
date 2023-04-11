package ru.qiwi.accounts;

public class PremiumAccount extends BankAccount {

    private int commission = 1;

    public PremiumAccount(double amount) {
        super(amount);
    }

    public void getCommission(){
        setAmount(getAmount() - commission);
    }

    @Override
    public void getMoney(double sum) {
        super.getMoney(sum);
        getCommission();
    }
}
