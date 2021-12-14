package com.naomi.basics;

import java.util.Scanner;

public class WhileDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter a password: ");
		int input = sc.nextInt();
		int password = 123;

		int c = 1;
		while (input != password && c < 3) {
			System.out.print("wrong password, enter again: ");
			input = sc.nextInt();
			c++;
		}

		if (input == password) {
			System.out.println("You are logged in");
		} else {
			System.out.println("Your attempts are over");
		}
		sc.close();
	}

}
