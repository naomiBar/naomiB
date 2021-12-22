package com.naomi.exercises;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] num1 = new int[25];
		int[] num2 = new int[25];
		
		for (int i = 0; i < num1.length; i++) {
			num1[i] = (int)(Math.random()*10);
			num2[i] = (int)(Math.random()*10);
			
		}
		
		System.out.println("num1: " + Arrays.toString(num1));
		System.out.println("num2: " + Arrays.toString(num2));
		
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
		
		int max1 = 0, max2 = 0;
		
		for (int i = 0; i < newArr1.length; i++) {
			if(newArr1[i]>max1) {
				max1 = newArr1[i];
			}
			if(newArr2[i]>max2) {
				max2 = newArr2[i];
			}
			
		}
		System.out.println("max1: "  + max1);
		System.out.println("max2: "  + max2);
		
		
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
		System.out.println("new arr - 5 biggest: " + Arrays.toString(newArr));
		
	}

}
