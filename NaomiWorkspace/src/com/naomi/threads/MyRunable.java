package com.naomi.threads;

/*this class is less efficient to use but we can use extend for something else*/
public class MyRunable implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

}
