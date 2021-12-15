package com.naomi.exercises;

public class Lab5 {

	public static void main(String[] args) {
		
		//number of digits: [5867 --> 4] 
		System.out.println("   Ex1:");
		int num1 = (int)(Math.random()*10_001);
		System.out.println("the number: " + num1);
		int length = 0;
		while(num1!=0) {
			length++;
			num1/=10;
		}
		System.out.println("the length of digits: " + length);
		
		//the right digit: [1998 --> 8]
		System.out.println("===============");
		System.out.println("   Ex2:");
		int num2 = (int)(Math.random()*10_001);
		System.out.println("the number: " + num2);
		System.out.println("the right digit: " + (num2%10));
		
		//the left digit: [1998 --> 1]
		System.out.println("===============");
		System.out.println("   Ex3:");
		int num3 = (int)(Math.random()*10_001);
		System.out.println("the number: " + num3);
		int leftDig = 0;
		while(num3!=0) {
			leftDig = num3%10;
			num3/=10;
		}
		System.out.println("the left digit: " + leftDig);
		
		//the opposite order of the number’s digits: [1998 --> 8991]
		System.out.println("===============");
		System.out.println("   Ex4:");
		int num4 = (int)(Math.random()*10_001);
		System.out.println("the number: " + num4);
		int temp = num4;
		int newNum = 0;
		while(temp!=0) {
			newNum = newNum*10 + temp%10;
			temp/=10;
		}
		System.out.println(num4 + " -> " + newNum);
		
		//sum of the number’s digits [ 473 --> 14]
		System.out.println("===============");
		System.out.println("   Ex5:");
		int num5 = (int)(Math.random()*10_001);
		System.out.println("the number: " + num5);
		int sum = 0;
		while(num5!=0) {
			sum+=num5%10;
			num5/=10;
		}
		System.out.println("the sum of the number’s digits: " + sum);
		
		System.out.println("===============");
		System.out.println("   Ex6:");
		System.out.println(num4 + " -> " + newNum);
		if(num4 == newNum) {
			System.out.println("the number " + num4 + " is palindrome");
		}
		else {
			System.out.println("the number " + num4 + " is not palindrome");
		}
	}
}
