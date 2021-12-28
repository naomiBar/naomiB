package com.naomi.threads;

public class MyRunableTest {

	public static void main(String[] args) {

		MyRunable runable = new MyRunable();
		
		Thread thread1 = new Thread(runable, "thread1");
		Thread thread2 = new Thread(runable, "thread2");
		thread1.start();
		thread2.start();
		
		//get a reference to the currently running thread
		Thread currThread = Thread.currentThread();
		for (int i = 1; i <= 100; i++) {
			System.out.println(currThread.getName() + ": " + i);
		}
	}

}
