package com.naomi.projects;

import java.util.Scanner;

public class ChangingIDNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("enter id number: ");
		int IDNumber = Integer.parseInt(sc.nextLine());
		
		long newIDNumber = addingDigit(IDNumber);
		System.out.println(newIDNumber);
		sc.close();
	}

	private static long addingDigit(int IDNumber) {
		int d1 = IDNumber % 10;
		int d10 = (IDNumber/10) % 10;
		
		long newIDNumber = IDNumber;
		int number = 0;
		for (int i = 0; i < d10; i++) {
			number = (int) (number *10 + newIDNumber % 10);
			newIDNumber /= 10;
		}
		newIDNumber = newIDNumber * 10 + d1;
		
		for (int i = 0; i < d10; i++) {
			newIDNumber = newIDNumber * 10 + (number % 10);
			number /= 10;
		}
		return newIDNumber;
	}

}
