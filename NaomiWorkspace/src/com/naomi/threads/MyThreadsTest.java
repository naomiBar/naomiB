package com.naomi.threads;

public class MyThreadsTest {

	public static void main(String[] args) {
		//3)create an object
		MyThreads thread = new MyThreads("Thread");
		thread.start(); //start run() in the thread
		
		//array of Threads
		MyThreads t1 = new MyThreads("t1");
		MyThreads t2 = new MyThreads("t2");
		MyThreads t3 = new MyThreads("t3");
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
