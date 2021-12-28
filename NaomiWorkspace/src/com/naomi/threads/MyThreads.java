package com.naomi.threads;

/*this class is more efficient to use but we cannot use another extend*/
public class MyThreads extends Thread{ //1)define a class that extends Thread
	
	//generate contractor from superclass with a another name to a new thread
	public MyThreads(String name) {
		super(name);
	}

	//2)override run from Thread class
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(getName() +": " + i);
		}
	}
	
	
}
