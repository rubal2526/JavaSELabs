package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
    
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    @Override
    public String toString() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��", accountNumber, ownerName, balance);
    }
}