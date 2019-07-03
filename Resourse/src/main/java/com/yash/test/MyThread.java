package com.yash.test;

public class MyThread implements Runnable{

	
	private Bank bank;
	
	
	public MyThread() {
		bank = new Bank();
	}
	
	@Override
	public void run() {
		try {
//			Thread.sleep(500);
			bank.diposit(550);
			bank.withDrow(550);
			bank.diposit(550);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		Thread thread  = new Thread(myThread);
		Thread thread1  = new Thread(myThread);
		thread.setName("t1");
		thread1.setName("t2");

//		for (int i = 0; i < 11; i++) {
//			Thread thread  = new Thread(myThread);
//			thread.start();
//		}
		
		thread1.start();
		thread.start();
//		thread.join();
//		thread1.join();
//		System.out.println(myThread.bank.getBalance());
		
		
		
	}
}
