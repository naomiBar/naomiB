package com.naomi.exercises.labs;

public class Lab3 {

	public static void main(String[] args) {

		// TaxCalculator:
		System.out.println("   Ex1:");
		double salary = 40000;//(Math.random() * 300_001);
		System.out.println("the salary before tax: " + salary);
		double tax = 0, newSal = salary;
		if (salary <= 23_000) {
			tax += salary * 0.1;
		}
		newSal -= 23_000;
		if (salary >= 23_000 && salary <= 50_000) {
			tax += 2300 + (newSal * 0.2);
		}
		newSal -= 27_000;
		if (salary >= 50_000 && salary <= 100_000) {
			tax += 2300 + 5400 + (newSal * 0.3);
		}
		newSal -= 50_000;
		if (salary > 100_000) {
			tax += 2300 + 5400 + 15_000 + (newSal * 0.4);
		}
		System.out.println("the tax: " + tax);
		System.out.println("the salary after tax : " + (salary - tax));

		
		
		// Leap year
		System.out.println("===============");
		System.out.println("   Ex3:");
		int year = (int) (Math.random() * 2021) + 1; // 1-2021
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("the year " + year + " is a leap year!");
		}
		else {
			System.out.println("the year " + year + " is not a leap year!");			
		}
	}

}
