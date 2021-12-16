package com.naomi.exercises;

public class Lab4 {

	public static void main(String[] args) {

		System.out.println("   Ex3:");
		int num = (int) (Math.random() * 101);
		System.out.println("the random number: " + num);
		for (int i = 1; i <= num; i++) {
			System.out.print(i + " ");
		}

		
		
		System.out.println("\n===============");
		System.out.println("   Ex4:");
		int a = (int) (Math.random() * 101); // 0-100 inclusive
		int b = (int) (Math.random() * 101); // 0-100 inclusive
		System.out.println("a: " + a + "\t b: " + b);
		int big = a > b ? a : b;
		int small = a > b ? b : a;
		for (int i = small; i <= big; i++) {
			System.out.print(i + " ");
		}

		
		
		System.out.println("\n===============");
		System.out.println("   Ex5:");
		num = (int) (Math.random() * 101);
		System.out.println("the random number: " + num);
		for (int i = 0; i <= num; i += 2) {
			System.out.print(i + " ");
		}

		
		
		System.out.println("\n===============");
		System.out.println("   Ex6:");
		int max = (int) (Math.random() * 101); // 0-100 inclusive
		int den = (int) (Math.random() * 11) + 1; // 1-10 inclusive
		System.out.println("max: " + max + "\t den: " + den);
		for (int i = 0; i <= max; i++) {
			if (i % den == 0) {
				System.out.print(i + " ");
			}
		}

		
		
		System.out.println("\n===============");
		System.out.println("   Ex7:");
		num = (int) (Math.random() * 7) + 1;
		System.out.println("the number: " + num);
		int factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}
		System.out.println("the factorial value : " + factorial);

		
		
		System.out.println("===============");
		System.out.println("   Ex8:");
		System.out.println("the number: " + num);
		factorial = 1;
		while (num != 0) {
			factorial *= num;
			num--;
		}
		System.out.println("the factorial value : " + factorial);
	}
}
