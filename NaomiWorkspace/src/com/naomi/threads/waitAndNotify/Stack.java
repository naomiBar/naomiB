package com.naomi.threads.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

public class Stack {
	
	private List<Integer> list = new ArrayList<>();
	public static final int MAX = 10;
	
	//push - add an element to a stack
	public synchronized void push(Integer val) {
		while(list.size() == MAX) {
			try {
				wait(); //Wait for the contents of the list to not be full up to the end
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(val); //add an element to the end of the list
		notify();
	}
	
	//pop - take an element out of a stack;
	public synchronized Integer pop() {
		while(list.isEmpty()) {
			try {
				wait(); //Wait for the contents of the list to not be completely empty
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int val = list.remove(list.size()-1); //remove the last element of the list
		notify();
		return val;
	}
	
}
