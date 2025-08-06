package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custid;
	private String acctid;
	private int balance;
	
	//default constructor ����
	public Account() {
		System.out.println("�⺻������ ȣ���");
	}
	
	//Constructor Overloading (������ �ߺ�����)
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
	
	//�Ա�
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	//���
	public void withdraw(int amount) throws InsufficientBalanceException {
		//�ܾ׺���
		if(amount > this.balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %d, ���� �ܾ�: %d)", amount, this.balance);
			//Exeption ������ �߻���Ŵ
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
	
}
