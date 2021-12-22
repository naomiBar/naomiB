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
		
		int[] arr = new int[5];
		System.out.println("arr: " + Arrays.toString(arr));
		for (int i = 0; i < newArr1.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(newArr1[i]  >= arr[j]) {
					int temp = arr[j];
					arr[j] = newArr1[i];
					if(j<4) {
						arr[++j] = temp;						
					}
				}
			}
		}
		System.out.println("arr: " + Arrays.toString(arr));
		
	}

}
