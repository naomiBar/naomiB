package com.naomi.threads.waitAndNotify;

public class Consumer extends Thread {

	private Stack stack;

	public Consumer(String name, Stack stack) {
		super(name);
		this.stack = stack;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			int val = stack.pop();
			System.out.println("-- POP: " + getName() + " poped: " + val);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
