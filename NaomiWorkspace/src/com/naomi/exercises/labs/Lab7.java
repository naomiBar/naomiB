package com.naomi.exercises.labs;

public class Lab7 {

	public static void main(String[] args) {

		System.out.println("   Ex1:");
		char[] arr = { 'a', 'b', 'c', 'a', 'b', 'd', 'r', 'c' };
		int count = 0;
		for (char c : arr) {
			if (c == 'a') {
				count++;
			}
		}
		System.out.println("‘a’ char inside the array " + count + " times");

		count = 0;
		for (char c : arr) {
			if (c == 'a' || c == 'c') {
				count++;
			}
		}
		System.out.println("‘a’ or ‘c’ chars inside the array " + count + " times");

		
		
		System.out.println("===============");
		System.out.println("   Ex2:");
		String name = "John Bryce";
		char[] ch = name.toCharArray();
		count = 0;
		for (char c : ch) {
			System.out.print(c);
			if (c == 'h') {
				count++;
			}
		}
		System.out.println("\n‘h’ char inside the string " + count + " times");

		
		
		System.out.println("===============");
		System.out.println("   Ex3:");
		String str = "Sara Shara Shir Cameach";
		char[] chars = str.toCharArray();
		count = 0;
		for (char c : chars) {
			if (Character.toUpperCase(c) == 'A' ||
					Character.toUpperCase(c) == 'E' ||
					Character.toUpperCase(c) == 'I' ||
					Character.toUpperCase(c) == 'O' ||
					Character.toUpperCase(c) == 'U') {
				count++;
			}
			System.out.print(c);
		}
		System.out.println("\ncount: " + count);
	}
}
