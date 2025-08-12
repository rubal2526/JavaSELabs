package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;
 class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    
    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > this.withdrawalLimit) {
            throw new WithdrawalLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + this.withdrawalLimit + "��");
        }
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�. ���� �ܾ�: " + getBalance() + "��");
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ��� �ѵ�: %.1f��", withdrawalLimit);
    }
}