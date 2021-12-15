package com.naomi.exercises;

public class Lab1 {

	public static void main(String[] args) {

		System.out.println("   Ex3:");
		int a = (int) (Math.random() * 101); // 0-100 inclusive
		int b = (int) (Math.random() * 101); // 0-100 inclusive
		System.out.println("a: " + a + "\t b: " + b);
		int sum = a + b;
		System.out.println("the sum of the numbers: " + sum);
		System.out.println("the average value of the numbers: " + (sum / 2));
		System.out.println("the remainder when dividing each in 10: " + "a-" + (a % 10) + "  b-" + (b % 10));
		System.out.println("the area of a rectangle: " + (a * b));

		
		System.out.println("===============");
		System.out.println("   Ex4:");
		// (b-a+1) + a; // a - b inclusive
		int minutes = (int) (Math.random() * 251) + 100; // 100-350 inclusive
		System.out.println("the time in minutes: " + minutes);
		System.out.println((minutes / 60) + ":" + (minutes % 60));
		
		
		System.out.println("===============");
		System.out.println("   Ex5:");
		int max = a>b ? a : b;
		System.out.println("the bigger value of the numbers: " + max);
	}
}
