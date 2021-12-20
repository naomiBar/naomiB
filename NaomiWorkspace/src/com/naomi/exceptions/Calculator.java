package com.naomi.exceptions;

import java.util.Scanner;

public class Calculator {

	public int div(int a, int b) throws Exception {

		if (b != 0) {
			return a / b;
		} else {
			Exception e = new Exception("eror");
			throw e;
		}
	}
	
	public int sum() {
		Scanner sc = new Scanner(System.in);
		int a,b;
		while(true) {
			try {
				System.out.print("enter first number: ");
				a = Integer.parseInt(sc.nextLine());
				System.out.print("enter second number: ");
				b = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("it's not a number!!!");
				System.out.print("enter again: ");
			}
		}
		sc.close();
		return a+b;
	}
}
