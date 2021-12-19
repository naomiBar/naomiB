package com.naomi.exercises;

import java.util.Arrays;

public class Lab8 {

	public static void main(String[] args) {

		System.out.println("   Ex2:");
		// creates an array[10] of numbers with random values between 0-100
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
		}
		// print all numbers each in the same line
		System.out.println(Arrays.toString(arr));

		
		
		System.out.println("\n===============");
		System.out.println("   Ex3:");
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		System.out.println("the total sum of the numbers: " + sum);

		
		
		System.out.println("===============");
		System.out.println("   Ex4:");
		System.out.println("the total average of the numbers: " + (sum / arr.length));

		
		
		System.out.println("===============");
		System.out.println("   Ex5:");
		int max = 0, index = 0;
		for (int i = 0; i < arr.length; i++) {
			// max = i > max ? i : max;
			if (arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		System.out.println("the maximum number: " + max);

		
		
		System.out.println("===============");
		System.out.println("   Ex6:");
		System.out.println("the maximum number and its index in the array: " + "arr[" + index + "]=" + max);

		
		
		System.out.println("===============");
		System.out.println("   Ex7:");
		int min = arr[0];
		index = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
				index = i;
			}
		}
		System.out.println("the minimum number and its index in the array: " + "arr[" + index + "]=" + min);
	}
}
