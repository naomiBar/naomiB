package com.naomi.exceptions;

public class Main {

	public static void main(String[] args) {
		Calculator c = new Calculator();

		try {
			int res = c.div(10, 5);
			System.out.println(res);
			
			res = c.div(1, 0);
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("cant divied by zero");
		}
		
		System.out.println(c.sum());

	}
}
