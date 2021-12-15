package com.naomi.exercises;

public class Lab2 {

	public static void main(String[] args) {

		System.out.println("   Ex1:");
		int num = (int) (Math.random() * 101);
		System.out.print("the number: " + num + " --> ");
		if (num < 50) {
			System.out.println("Small!");
		} else if (num > 50) {
			System.out.println("Big!");
		} else {
			System.out.println("Bingo!");
		}

		System.out.println("===============");
		System.out.println("   Ex2:");
		if (num % 2 == 0) {
			System.out.println("the number " + num + " is even");
		} else {
			System.out.println("the number " + num + " is odd");
		}

		//SalaryRaiser
		System.out.println("===============");
		System.out.println("   Ex3:");
		double salary = (Math.random() * 1001) + 5000;
		System.out.println("the current salary: " + salary);
		double newSal = salary * 1.1;
		if (newSal > 6000) {
			newSal *= 1.05;
		}
		System.out.println("the updated salary: " + newSal);
		
		System.out.println("===============");
		System.out.println("   Ex4:");
		int a = (int) (Math.random() * 101); // 0-100 inclusive
		int b = (int) (Math.random() * 101); // 0-100 inclusive
		int c = (int) (Math.random() * 101); // 0-100 inclusive
		System.out.println("a: " + a + "\t b: " + b + "\t c: " + c);
		if(a>=b && a>=c) {
				System.out.println(a + " is the bigger value");
		}
		else if(b>=c && b>=a) {
				System.out.println(b + " is the bigger value");				
		}
		else {
				System.out.println(c + " is the bigger value");								
		}
		
		System.out.println("===============");
		System.out.println("   Ex5:");
		if(a<=b && a<=c) {
			System.out.println(a + " is the smaller value");
		}
		else if(b<=c && b<=a) {
				System.out.println(b + " is the smaller value");				
		}
		else {
				System.out.println(c + " is the smaller value");								
		}
	}

}
