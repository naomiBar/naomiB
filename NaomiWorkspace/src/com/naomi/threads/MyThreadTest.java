package com.naomi.threads;

public class MyThreadTest {

	public static void main(String[] args) {
		//3)create an object
		MyThread thread = new MyThread("Thread");
		thread.start(); //start run() in the thread
		
		//array of Threads
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		MyThread t3 = new MyThread("t3");
		Thread[] threads = {t1,t2,t3};
		for (Thread t : threads) {
			t.start();
		}
		
		
		Thread currThread = Thread.currentThread(); //get a reference to the currently running thread
		for (int i = 1; i <= 100; i++) {
			System.out.println(currThread.getName() + ": " + i);
		}
	}

}
