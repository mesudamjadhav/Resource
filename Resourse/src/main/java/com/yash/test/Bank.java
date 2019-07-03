package com.yash.test;

public class Bank {
	private Integer balance;

	public Bank(){
		balance = 1000;
	}
	
	void withDrow(Integer integer) throws InterruptedException{
		int count=0;
		if(balance >= integer){
			Thread.sleep(5000);
			balance = balance - integer;
			System.out.println(++count);
		}
		System.out.println(balance);
	}
	
	public void diposit(Integer integer) throws InterruptedException{
		
		balance = balance + integer;
	}
	
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	
}
