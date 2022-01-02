package com.naomi.threads;

public class MyThreadStateTest {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		System.out.println("=== is t1 alive? " + t1.isAlive());
		
		// print NEW state
		System.out.println(t1.getState());
		
		t1.start();
		// print RUNNABLE state
		System.out.println(t1.getState());
		
		System.out.println("=== is t1 alive? " + t1.isAlive());
		System.out.println("=== is t1 interrupt? " + t1.isInterrupted());
		
		try {
			// main waits for t1 to be in sleep
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// print TIMED_WAITING state
		System.out.println(t1.getState());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println("=== is t1 interrupt? " + t1.isInterrupted());
		
		
		// main waits for t1 to die
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// print TERMINATED state
		System.out.println(t1.getState());
		System.out.println("=== is t1 alive? " + t1.isAlive());

	}

}
