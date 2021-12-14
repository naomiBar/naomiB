package com.naomi.basics;

public class Random {

	public static void main(String[] args) {
		
		System.out.println(Math.random()); // 0 - 0.99999
		System.out.println(Math.random() * 11); // 0 - 10.99999
		System.out.println((int) (Math.random() * 11)); // 0 - 10
		System.out.println("==============");
		
		int y = (int) (Math.random() * 10_001); //0-10000
		System.out.println(y);
		System.out.println(y % 10);
		
		int day = (int) (Math.random() * 7); // 0 - 6 inclusive
		System.out.println(day);
		day = (int) (Math.random() * 7) + 1; // 1 - 7 inclusive
		System.out.println(day);
		
		int x = (int) (Math.random() * 11) + 10; // 10 - 20 inclusive 
		System.out.println(x);
		
		int a = -5, b =5;
		int r = (int) (Math.random() * (b-a+1)) + a; // a - b inclusive 
		System.out.println(r);

	}

}
