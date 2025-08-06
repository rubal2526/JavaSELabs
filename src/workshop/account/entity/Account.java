package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custid;
	private String acctid;
	private int balance;
	
	//default constructor 선언
	public Account() {
		System.out.println("기본생성자 호출됨");
	}
	
	//Constructor Overloading (생성자 중복정의)
	public Account(String custid, String acctid, int balance) {
//		this.custid = custid;
//		this.acctid = acctid;
		setCustid(custid);
		setAcctid(acctid);
		this.balance = balance;
	}
	
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	public int getBalance() {
		return balance;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
	
	public void setAcctid(String acctid) {
		this.acctid = acctid;
	}
	
	public String getAcctid() {
		return acctid;
	}
	
	//입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	//출금
	public void withdraw(int amount) throws InsufficientBalanceException {
		//잔액부족
		if(amount > this.balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액: %d)", amount, this.balance);
			//Exeption 강제로 발생시킴
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
	
}
