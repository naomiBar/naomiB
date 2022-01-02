package com.naomi.threads;

import java.util.Date;

/*this class is more efficient to use but we cannot use another extend*/
public class MyThread extends Thread{ //1)define a class that extends Thread
	
	//generate contractor from superclass with a another name to a new thread
	public MyThread(String name) {
		super(name);
	}

	//2)override run from Thread class
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(getName() +": " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(new Date());
				return;
			}
		}
	}
	
	
}
