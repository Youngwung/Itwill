package com.itwill.class06;

/**
 * 은행 계좌 정보.
 * 속성: 계좌 번호, 잔고.
 * 기능: 입급, 출금, 이체, 정보 출력.
 */

public class Account {
	//field
	int accountNo; //계좌번호
	int balance; //잔고
	
	// constructor: 아규먼트 2개를 갖는 생성자
	public Account(int acc, int bal) {
		this.accountNo = acc;
		this.balance = bal;		
	}
	// method
	/**
	 * deposit(입금). 현재 잔고에 입금액을 더하고, 입금 후의 잔액을 리턴.
	 * @param amount 입금액(int)
	 * @return balance 입금 후의 잔고(int).
	 */
	public int deposit(int amount) {
		return this.balance += amount;
	}
	/**
	 * withdraw(출금). 현재 잔고에 출금액을 빼고, 입금 후의 잔고를 리턴.
	 * @param amount 출금액(int)
	 * @return balance 출금 후의 잔고(balance).
	 */
	public int withdraw(int amount) {
		return this.balance -= amount;
	}
	/**
	 * transfer(이체). 내 계좌의 잔고에서는 이체금액 amount를 빼고, 
	 * 이체할 계좌에서는 이체금액 amount를 더한다.
	 * @param to 이체할 계좌(Account)타입
	 * @param amount 이체할 금액.
	 * @return true.
	 */
	public boolean transfer(int amount, Account to) {
		to.balance += amount;
		this.balance -= amount;				
		return true;
	}
	
	
	/**
	 * 계좌 정보 출력
	 */
	public void info() {
		System.out.println("-----계좌 정보-----");
		System.out.println("계좌 번호: "+ accountNo);
		System.out.println("잔액: "+ balance);
	}
	
	
}