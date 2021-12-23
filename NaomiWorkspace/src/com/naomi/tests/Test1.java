package com.naomi.tests;

import java.util.Arrays;

public class Test1 {

	static int[] distinct;
	static int count = 0;

	public static void main(String[] args) {

		// exercise 1
		int[] num1 = new int[15];
		int[] num2 = new int[15];

		for (int i = 0; i < num1.length; i++) {
			num1[i] = (int) (Math.random() * 10);
			num2[i] = (int) (Math.random() * 10);
		}

		// exercise 2
		System.out.println("num1: " + Arrays.toString(num1));
		System.out.println("num2: " + Arrays.toString(num2));

		// exercise 3
		System.out.println("maxnum: " + foundMaxNumber(num1));

		// exercise 4
		designArr(num1);
		designArr(num2);
		System.out.println("num1: " + Arrays.toString(num1));
		System.out.println("num2: " + Arrays.toString(num2));

		distinct = new int[10];
		initializationArr();

		checkDig(num1, num2);
		checkDig(num2, num1);

		// exercise 5
		System.out.println("distinct: " + Arrays.toString(distinct));

		// exercise 6
		if (count > 0) {
			System.out.println("the number: " + CreatingNum());
		} else {
			System.out.println("No distinct number was found");
		}

	}

	public static int foundMaxNumber(int[] arr) {
		int maxDig = arr[0];
		int num = 0;
		int maxNum = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i] >= maxDig) {
				maxDig = arr[i];
				num = arr[i] * 100 + arr[i + 1] * 10 + arr[i + 2];
			}
			if (num > maxNum) {
				maxNum = num;
			}
		}

		// Checking in the other direction
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] >= maxDig) {
				maxDig = arr[i];
				num = arr[i] * 100 + arr[i - 1] * 10 + arr[i - 2];
			}
			if (num > maxNum) {
				maxNum = num;
			}
		}
		return maxNum;
	}

	public static int[] designArr(int[] arr) {
		Arrays.sort(arr);

		// Replaces the duplicates to -1 in both arrays
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				arr[i] = -1;
			}
		}
		Arrays.sort(arr);

		return arr;
	}

	public static void initializationArr() {
		for (int i = 0; i < distinct.length; i++) {
			distinct[i] = -1;
		}
	}

	public static void checkDig(int[] a, int[] b) {
		lbl: for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					continue lbl;
				}
			}
			distinct[count++] = a[i];
		}
	}

	public static int CreatingNum() {
		int num = distinct[0];
		for (int i = 1; i < count; i++) {
			num = num * 10 + distinct[i];
		}
		return num;
	}

}
