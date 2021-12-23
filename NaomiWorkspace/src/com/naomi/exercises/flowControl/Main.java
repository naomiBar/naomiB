package com.naomi.exercises.flowControl;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		// exercise 1
		int[] num1 = new int[25];
		int[] num2 = new int[25];
		
		for (int i = 0; i < num1.length; i++) {
			num1[i] = (int)(Math.random()*10);
			num2[i] = (int)(Math.random()*10);
			
		}
		
		// exercise 2
		System.out.println("num1: " + Arrays.toString(num1));
		System.out.println("num2: " + Arrays.toString(num2));
		
		// exercise 3
		int[] newArr1 = new int[10];
		int[] newArr2 = new int[10];
		
		for (int i = 0; i < num1.length; i++) {
			for (int j = 0; j < newArr1.length; j++) {
				if(num1[i] == j) {
					newArr1[j] = newArr1[j] *  10 +  j; 
				}
				if(num2[i] == j) {
					newArr2[j] = newArr2[j] *  10 +  j; 
				}
				
			}
		}
		System.out.println("newArr1: " + Arrays.toString(newArr1));
		System.out.println("newArr2: " + Arrays.toString(newArr2));
		
		Arrays.sort(newArr1);
		Arrays.sort(newArr2);
		
		System.out.println("max1: "  + newArr1[9]);
		System.out.println("max2: "  + newArr2[9]);
		
		
		// exercise 4
		int[] arr = new int[20];
		System.arraycopy(newArr1, 0, arr, 0, 10);
		System.arraycopy(newArr2, 0, arr, 10, 10);
		System.out.println("arr: " + Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println("arr after sort: " + Arrays.toString(arr));
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				arr[i] = 0;
			}
		}
		Arrays.sort(arr);
		System.out.println("arr after sort2: " + Arrays.toString(arr));
		
		int[] newArr = new int[5];
		System.arraycopy(arr, 15, newArr, 0, 5);
		
		// exercise 5
		System.out.println("new arr - 5 biggest: " + Arrays.toString(newArr));
	}
}
