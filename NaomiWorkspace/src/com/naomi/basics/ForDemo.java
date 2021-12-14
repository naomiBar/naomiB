package com.naomi.basics;

public abstract class ForDemo {

	public static void main(String[] args) {

		// print all numbers from 100 - 50 inclusive
		for (int i = 100; i >= 50; i--) {
			System.out.print(i + " ");
		}
		System.out.println("\n===============");

		// print all even numbers from 100 - 200 inclusive
		for (int i = 100; i <= 200; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n===============");

		// print all numbers from 0 - 100 that divide by 7
		for (int i = 0; i <= 100; i++) {
			if (i % 7 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n===============");

		// print all numbers from 'a' - 'z' inclusive
		for (int c = 'a'; c <= 'z'; c++) {
			System.out.print((char) c + " ");
		}
		System.out.println("\n===============");

		// print all numbers from 'A' - 'Z' inclusive
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c + "-" + (int) c + "  ");
		}
		System.out.println("\n===============");

		// print the following using for loop
		// 0-10, 1-9, 2-8 .... 10-0
		for (int i = 0, j = 10; i <= 10 && j >= 0; i++, j--) {
			System.out.println(i + " - " + j);
		}
	}
}
