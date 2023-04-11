package ru.qiwi.accounts;

public class BankAccount {

    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void getMoney(double summ) {
        amount -= summ;
    }
}
