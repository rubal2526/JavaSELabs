package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    private String generateAccountNumber() {
        return "AC" + nextAccountNumber++;
    }

    public Account createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = generateAccountNumber();
        Account newAccount = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(newAccount);
        System.out.println("���� ���°� �����Ǿ����ϴ�: " + newAccount);
        return newAccount;
    }

    public Account createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = generateAccountNumber();
        Account newAccount = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(newAccount);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + newAccount);
        return newAccount;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }
    
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
        System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", amount, account.getBalance());
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��\n", amount, account.getBalance());
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.\n", amount, fromAccountNumber, toAccountNumber);
    }

    public void printAllAccounts() {
        System.out.println("=== ��� ���� ��� ===");
        for (Account account : accounts) {
            System.out.println(account);
        }
        System.out.println("===================");
    }
}