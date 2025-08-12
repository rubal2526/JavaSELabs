package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        Account acc1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
        Account acc2 = bank.createCheckingAccount("김철수", 20000, 5000.0);
        Account acc3 = bank.createSavingsAccount("이영희", 30000, 2.0);
        System.out.println();

        bank.printAllAccounts();
        System.out.println();
        
        System.out.println("=== 입금/출금 테스트 ===");
        try {
            bank.deposit(acc1.getAccountNumber(), 5000);
            bank.withdraw(acc2.getAccountNumber(), 3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== 이자 적용 테스트 ===");
        if (acc1 instanceof SavingsAccount) {
            ((SavingsAccount) acc1).addInterest();
        }
        System.out.println();
        
        System.out.println("=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(acc3.getAccountNumber(), acc2.getAccountNumber(), 5000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();
        
        bank.printAllAccounts();
        System.out.println();
        
        System.out.println("=== 예외 처리 테스트 ===");
        try {
            bank.withdraw(acc2.getAccountNumber(), 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        try {
            bank.withdraw(acc2.getAccountNumber(), 50000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        try {
            bank.deposit("AC9999", 1000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}