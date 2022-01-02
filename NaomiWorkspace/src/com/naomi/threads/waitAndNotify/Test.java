package com.naomi.threads.waitAndNotify;

public class Test {

	public static void main(String[] args) {
		Stack stack = new Stack();
		
		Producer p1 = new Producer("p1", stack);
		p1.start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Consumer c1 = new Consumer("c1", stack);
		c1.start();
	}

}
