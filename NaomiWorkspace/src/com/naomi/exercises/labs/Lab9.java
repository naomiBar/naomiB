package com.naomi.exercises.labs;

import java.util.Arrays;

public class Lab9 {

	public static void main(String[] args) {

		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*101); //0-100
		}
		System.out.print("all the numbers: ");
		System.out.println(Arrays.toString(arr));
		
		
		
		System.out.println("\n===============");
		System.out.println("   Ex1:");
		System.out.print("all evens numbers: ");
		int sumEvens = 0;
		for (int i : arr) {
			if(i%2==0) {
				System.out.print(i + " ");
				sumEvens += i; //ex3
			}
		}
		
		
		
		System.out.println("\n===============");
		System.out.println("   Ex2:");
		System.out.print("all odds numbers: ");
		int sumOdds = 0;
		for (int i : arr) {
			if(i%2!=0) {
				System.out.print(i + " ");
				sumOdds += i; //ex4
			}
		}

		
		
		System.out.println("\n===============");
		System.out.println("   Ex3:");
		System.out.println("sum of all even numbers: " + sumEvens);

		
		
		System.out.println("===============");
		System.out.println("   Ex4:");
		System.out.println("sum of all odd numbers: " + sumOdds);

		
		
		System.out.println("===============");
		System.out.println("   Ex5:");
		int max = sumEvens > sumOdds ? sumEvens : sumOdds;
		System.out.println("this sum is greater: " + max);
		
		
		
		System.out.println("===============");
		System.out.println("   Ex6:");
		int highest = arr[0], indexMax = 0;
		int lowest = arr[0], indexMin = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>highest) {
				highest = arr[i];
				indexMax = i;
			}
			if(arr[i]<lowest) {
				lowest = arr[i];
				indexMin = i;
			}
		}
		System.out.println("the highest value and its index in the array: arr[" + indexMax + "]=" + highest);
		System.out.println("the lowest value and its index in the array: arr[" + indexMin + "]=" + lowest);
		
	}
}
